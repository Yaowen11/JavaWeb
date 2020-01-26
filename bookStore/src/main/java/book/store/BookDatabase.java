package book.store;

import javax.naming.Context;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import javax.naming.*;

/**
 * @author z
 */
public class BookDatabase {

    private DataSource dataSource = null;

    public BookDatabase () throws Exception {
        Context context = new InitialContext();
        dataSource = (DataSource) context.lookup("java:comp/env/jdbc/bookDB");
    }
    public Connection getConnection() throws Exception {
        return dataSource.getConnection();
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
        PreparedStatement preparedStatement = connection.prepareStatement("select * from books where ID = ?");
        preparedStatement.setString(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("update books set sale_amount = sale_amount + ? where id = ?");
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, bookId);
            preparedStatement.executeUpdate();
        }
        closeResultSet(resultSet);
        closePrepStmt(preparedStatement);
    }
}
