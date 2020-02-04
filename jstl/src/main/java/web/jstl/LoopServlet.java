package web.jstl;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/loop"})
public class LoopServlet extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        List<Client> clientlist = new ArrayList<>();
        Client client = new Client();
        client.setFirstname("Xiaowen");
        client.setLastname("zhao");
        client.setPhone("56781234");
        clientlist.add(client);

        client = new Client();
        client.setFirstname("Xiaowei");
        client.setLastname("qian");
        client.setPhone("56782345");
        clientlist.add(client);

        client = new Client();
        client.setFirstname("Xiaojie");
        client.setLastname("Sun");
        client.setPhone("56783456");
        clientlist.add(client);

        ctx.put("clientlist", clientlist);
        return getTemplate("loop.vm");
    }
}
