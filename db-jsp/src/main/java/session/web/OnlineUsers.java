package session.web;

import java.util.ArrayList;
import java.util.List;

/**
 * @author z
 */
public class OnlineUsers {

    private static final OnlineUsers ONLINE_USER = new OnlineUsers();

    private List<String> users = new ArrayList<>();

    public void add(String name) {
        users.add(name);
    }

    public void remove(String name) {
        users.remove(name);
    }

    public List<String> getUsers() {
        return users;
    }

    public int getCount() {
        return users.size();
    }

    public static OnlineUsers getInstance() {
        return ONLINE_USER;
    }
}
