package book.store;

/**
 * @author z
 */
public class ShoppingCartItem {
    private Object item;
    private int quantity = 1;

    public ShoppingCartItem(Object anItem) {
        item = anItem;
    }
    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public Object getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
