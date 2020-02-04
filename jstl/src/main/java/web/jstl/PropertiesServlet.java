package web.jstl;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/properties"})
public class PropertiesServlet extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        Client client=new Client();
        client.setFirstname("Weiqin");
        client.setLastname("ke");
        client.setPhone("56781234");
        ctx.put("client",client);
        return getTemplate("properties.vm");
    }
}
