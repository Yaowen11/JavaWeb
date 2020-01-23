package book.store;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author z
 */
public class ShoppingCart {

    private HashMap<String, ShoppingCartItem> itemHashMap = new HashMap<>();
    private int numberOfItems = 0;

    public synchronized void add(String bookId, BookDetails bookDetails) {
        if (itemHashMap.containsKey(bookId)) {
            ShoppingCartItem shoppingCartItem = itemHashMap.get(bookId);
            shoppingCartItem.incrementQuantity();
        } else {
            ShoppingCartItem newItem = new ShoppingCartItem(bookDetails);
            itemHashMap.put(bookId, newItem);
        }
        numberOfItems++;
    }
    public synchronized void remove(String bookId) {
        if (itemHashMap.containsKey(bookId)) {
            ShoppingCartItem shoppingCartItem = itemHashMap.get(bookId);
            shoppingCartItem.decrementQuantity();
            if (shoppingCartItem.getQuantity() <= 0) {
                itemHashMap.remove(bookId);
            }
            numberOfItems--;
        }
    }

    public synchronized Collection<ShoppingCartItem> getItems() {
        return itemHashMap.values();
    }

    public synchronized int getNumberOfItems() {
        return numberOfItems;
    }

    public synchronized double getTotal() {
        double amount = 0.0;
        if (itemHashMap.isEmpty()) {
            return amount;
        }
        for (ShoppingCartItem item : itemHashMap.values()) {
            BookDetails bookDetails = (BookDetails) item.getItem();
            amount += item.getQuantity() * bookDetails.getPrice();
        }
        return (Math.round(amount * 100)) / 100.0;
    }

    public synchronized void clear() {
        itemHashMap.clear();
        numberOfItems = 0;
    }
}
