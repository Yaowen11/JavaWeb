package session.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author z
 */
public class ShoppingCart implements Serializable {

    Map<String, Integer> items = new HashMap<>();

    int numberOfItems = 0;

    public synchronized void add(String itemName) {
        if (items.containsKey(itemName)) {
            Integer itemCount = items.get(itemName);
            items.put(itemName, itemCount + 1);
        } else {
            items.put(itemName, 1);
        }
        numberOfItems++;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    synchronized public Map<String, Integer> getItems() {
        return items;
    }
}
