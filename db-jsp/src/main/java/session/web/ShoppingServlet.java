package session.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/shopping"})
public class ShoppingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] itemNames = {"糖果", "收音机", "练习册"};
        HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String[] itemsSelected = req.getParameterValues("item");

        if (itemsSelected != null) {
            for (String item: itemsSelected) {
                cart.add(itemNames[Integer.parseInt(item)]);
            }
        }

        out.println("<html><head><title>购物车</title></head><body>");
        out.println("Session ID:" + session.getId() + "<br>");
        out.println("<center><h1>你的购物车有: " + cart.getNumberOfItems() + "个商品: </h1></center>");

        Map<String, Integer> items = cart.getItems();

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            out.println(entry.getKey() + ":" + entry.getValue() + "<br>");
        }
        out.println("<br><a href='shopping.html'>继续购物</a><br>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
