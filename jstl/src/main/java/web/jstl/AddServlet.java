package web.jstl;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author z
 */
@WebServlet(
        urlPatterns = {"/add"},
        initParams = {@WebInitParam(name = "org.apache.velocity.properties", value = "/WEB-INF/velocity.properties")},
        loadOnStartup = 1
        )
public class AddServlet extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        int a = 11;
        int b = 22;
        int c = a + b;
        ctx.put("a", a);
        ctx.put("a", a);
        ctx.put("a", a);
        return getTemplate("add.vm");
    }
}
