package cc.openhome.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String ENCODING;

    public void init(FilterConfig config) throws ServletException{
        ENCODING = config.getInitParameter("ENCODING");
    }

    public void doFilter(ServletRequest request, ServletResponse response ,FilterChain chain)
    throws IOException,ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        if("GET".equals(req.getMethod())){
            req = new EncodingWrapper(req,ENCODING);
        }
        else {
            req.setCharacterEncoding(ENCODING);
        }
        chain.doFilter(req,response);
    }
    public void destroy(){}
}
