package cc.openhome.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class EncodingWrapper extends HttpServletRequestWrapper {
    private String ENCODING;
    public EncodingWrapper(HttpServletRequest req, String ENCODING){
        super(req);
        this.ENCODING = ENCODING;
    }

    public String getParameter(String name){
        String value = getRequest().getParameter(name);
        if(value != null){
            try {
                byte [] b = value.getBytes("ISO-8859-1");
                value = new String(b,ENCODING);
            }catch (UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}
