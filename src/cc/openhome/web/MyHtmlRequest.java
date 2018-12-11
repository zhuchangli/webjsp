package cc.openhome.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/*
字符过滤功能
*/
public class MyHtmlRequest extends HttpServletRequestWrapper {

    private HttpServletRequest req;
    public MyHtmlRequest(HttpServletRequest req){

        super(req);
        this.req = req;
    }

    public String getParameter(String name){
        String value = getRequest().getParameter(name);
        if(value == null){
            return null;
        }
        return filter(value);
    }

    public String [] getParameterValues(String name){
        String [] values = getRequest().getParameterValues(name);
        String [] res = new String[values.length];
        if(values == null){
            return null;
        }
        for(int i = 0;i < values.length;i++){
            res[i] = filter(values[i]);
        }
        return res;

    }

    public Map<String,String[]> getParameterMap(){
        Map<String,String[]> values = getRequest().getParameterMap();
        Map<String,String[]> res = new HashMap<String, String[]>();
        List <String> listv= new ArrayList<String>();
        String [] arrv;
        for(Iterator<String> it = values.keySet().iterator();it.hasNext();){
            String k = it.next();
            String [] v = values.get(k);
            if(v == null || v.length == 0){
                continue;
            }
            else {
                for (int i = 0;i < v.length;i++){
                    listv.add(filter(v[i]));
                }
                arrv = new String[listv.size()];
                arrv = listv.toArray(arrv);
            }
            res.put(k,arrv);
        }
        if(res == null){
            return null;
        }
        return res;
    }

    public String filter(String message){
        if(message == null){
            return null;
        }
        char content[] = new char[message.length()];
        message.getChars(0,message.length(),content,0);
        StringBuilder result = new StringBuilder(content.length + 50);
        for(int i = 0;i < content.length;i++){
            switch (content[i]){
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot");
                    break;
                default:
                    result.append(content[i]);
            }
        }
        return result.toString();
    }
}
