package cc.openhome.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
字符过滤功能
*/
// <a href="http://openhome.cc">Openhome.cc</a>
@WebFilter("/*")
public class HtmlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest sreq, ServletResponse sresp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sreq;
        HttpServletResponse resp = (HttpServletResponse) sresp;
        MyHtmlRequest mreq = new MyHtmlRequest(req);
        chain.doFilter(mreq,resp);
    }
    @Override
    public void destroy() {

    }
}
