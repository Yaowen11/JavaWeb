package book.store;

/**
 * @author z
 */
public class BookDetails implements Comparable<Object> {
    private String bookId = null;
    private String title = null;
    private String author = null;
    private float price = 0.0F;
    private int online = 0;
    private String description = null;
    private int saleAmount;

    public static class Builder {
        private String bookId = null;
        private String title = null;
        private String author = null;
        private float price = 0.0F;
        private int online = 0;
        private String description = null;
        private int saleAmount;

        public Builder(String bookId) {
            this.bookId = bookId;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }

        public Builder online(int online) {
            this.online = online;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder saleAmount(int saleAmount) {
            this.saleAmount = saleAmount;
            return this;
        }

        public BookDetails build() {
            return new BookDetails(this);
        }
    }

    private BookDetails(Builder builder) {
        bookId = builder.bookId;
        title = builder.title;
        author = builder.author;
        price = builder.price;
        online = builder.online;
        description = builder.description;
        saleAmount = builder.saleAmount;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public String getDescription() {
        return description;
    }

    public int getOnline() {
        return online;
    }

    @Override
    public int compareTo(Object o) {
        BookDetails bookDetails = (BookDetails) o;
        return Integer.compare(Integer.parseInt(bookId), Integer.parseInt(bookDetails.getBookId()));
    }
}
