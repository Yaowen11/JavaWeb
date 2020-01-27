package session.web;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author z
 */
@WebListener
public class OnlineCounterListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        Integer counter = (Integer) context.getAttribute("counter");
        if (counter == null) {
            counter = 1;
        } else {
            counter++;
        }
        context.setAttribute("counter", counter);
        session.setMaxInactiveInterval(60);
        System.out.println("A new session is created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        Integer counter = (Integer) context.getAttribute("counter");
        if (counter != null) {
            counter--;
        }
        context.setAttribute("counter", counter);
        System.out.println("A new session is to be destroyed");
    }
}
