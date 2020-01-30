package web.el;

/**
 * EL 函数对应类
 * @author z
 */
public class Tool {
    public static int add(String x, String y) {
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(x);
            b = Integer.parseInt(y);
        } catch (Exception ignored) {

        }
        return a + b;
    }

    public static String covert(String str) {
        try {
            return str.toUpperCase();
        } catch (Exception ignored) {

        }
        return "";
    }
}
