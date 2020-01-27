package session.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author z
 */
@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("A new session is created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("A new session is to be destroyed.");
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent event){
        System.out.println("Attribute("+event.getName()+"/"+event.getValue()+") is added into a session.");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event){
        System.out.println("Attribute("+event.getName()+"/"+event.getValue()+") is removed from a session.");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event){
        System.out.println("Attribute("+event.getName()+"/"+event.getValue()+") is replaced in a session.");
    }
}
