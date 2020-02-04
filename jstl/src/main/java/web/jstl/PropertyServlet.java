package web.jstl;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/property"})
public class PropertyServlet extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        Map<String,String> client=new HashMap<>(3);
        client.put("firstname","Weiqin");
        client.put("lastname","zhao");
        client.put("phone","56781234");
        ctx.put("client",client);
        return getTemplate("properties.vm");
    }
}
