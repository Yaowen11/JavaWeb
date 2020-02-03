package web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author z
 */
public class MyRequestWrapper extends HttpServletRequestWrapper {
    public MyRequestWrapper(HttpServletRequest request) { super(request);}

    @Override
    public String getParameter(String name){
        String value=super.getParameter(name);
        if(value==null){
            value="none";
        }else{
            //把请求参数中的“-”替换为“/”
            value=value.replaceAll("-","/");
        }
        return value;
    }
}
