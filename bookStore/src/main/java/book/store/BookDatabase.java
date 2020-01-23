package book.store;

import java.sql.*;
import java.util.*;

/**
 * @author z
 */
public class BookDatabase {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://mysql8:3306/web?user=root&password=secret");
    }

    public void closeConnection(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closePrepStmt(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getNumberOfBooks() throws Exception {
        int count = 0;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from books");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        }
        return count;
    }

    public Collection<BookDetails> getBooks() throws Exception {
        ArrayList<BookDetails> bookDetails = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from books");
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                BookDetails bookDetails1 = new BookDetails.Builder(resultSet.getString("id"))
                        .author(resultSet.getString("author"))
                        .title(resultSet.getString("title"))
                        .price(resultSet.getFloat("price"))
                        .online(resultSet.getInt("online"))
                        .description(resultSet.getString("description"))
                        .saleAmount(resultSet.getInt("sale_amount"))
                        .build();
                bookDetails.add(bookDetails1);
            }
        }
        return bookDetails;
    }

    public BookDetails getBookDetails(String bookId) throws Exception {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from books where ID = ?");
        ) {
            preparedStatement.setString(1, bookId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new BookDetails.Builder(resultSet.getString("id"))
                            .author(resultSet.getString("author"))
                            .title(resultSet.getString("title"))
                            .price(resultSet.getFloat("price"))
                            .online(resultSet.getInt("online"))
                            .description(resultSet.getString("description"))
                            .saleAmount(resultSet.getInt("sale_amount"))
                            .build();
                }
            }
        }
        return null;
    }

    public void buyBooks(ShoppingCart cart) throws Exception {
        try (Connection connection = getConnection()
        ) {
            Collection items = cart.getItems();
            Iterator iterator = items.iterator();
            connection.setAutoCommit(false);
            while (iterator.hasNext()) {
                ShoppingCartItem shoppingCartItem = (ShoppingCartItem) iterator.next();
                BookDetails bookDetails = (BookDetails) shoppingCartItem.getItem();
                String id = bookDetails.getBookId();
                int quantity = shoppingCartItem.getQuantity();
                buyBook(id, quantity, connection);
            }
            connection.commit();
            connection.setAutoCommit(true);
        }
    }

    private void buyBook(String bookId, int quantity, Connection connection) throws Exception {
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from books where ID = ?")) {
            preparedStatement.setString(1, bookId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    preparedStatement.clearBatch();
                    preparedStatement.executeUpdate("update books set sale_amount = sale_amount + ? where id = ?");
                    preparedStatement.setInt(1, quantity);
                    preparedStatement.setString(2, bookId);
                    preparedStatement.execute();
                }
            }
        }
    }
}
