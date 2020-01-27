package session.web;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * @author z
 */
public class MyData implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {

    private int data;

    public MyData() {}

    public MyData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event){
        System.out.println("MyData is bound with a session.");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event){
        System.out.println("MyData is unbound with a session.");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se){
        System.out.println("A session is activate.");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se){
        System.out.println("A session will be passivate.");
    }
}
