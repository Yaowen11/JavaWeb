package session.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;

/**
 * @author z
 */
@WebListener
public class User implements HttpSessionBindingListener, Serializable {

    private OnlineUsers onlineUsers = OnlineUsers.getInstance();

    private String name = null;

    public User() {
        this("");
    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        onlineUsers.add(name);
        System.out.println(name + " is bound with a session");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        onlineUsers.remove(name);
        System.out.println(name + " is unbound with a session");
    }
}
