package chapter4;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/image"})
public class ImageServlet extends HttpServlet {
    private Font font = new Font("Courier", Font.BOLD, 12);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String count = req.getParameter("count");
        if (count == null) {
            count = "1";
        }
        int len = count.length();

        resp.setContentType("image/jpeg");
        ServletOutputStream out = resp.getOutputStream();
        BufferedImage image = new BufferedImage(11 * len, 16, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 11 * len, 16);
        graphics.setColor(Color.white);
        graphics.setFont(font);
        char c;
        for (int i = 0; i < len; i++) {
            c = count.charAt(i);
            graphics.drawString(c + "", i * 11 + 1, 12);
            graphics.drawLine((i + 1) * 11 - 1, 0, (i + 1) * 11 - 1, 16);
        }
        ImageIO.write(image, "jpeg", out);
        out.close();
    }
}
