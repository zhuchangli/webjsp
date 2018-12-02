package cc.openhome.model;/*
 * created by on 11/29/18
 */

import java.io.Serializable;
import java.util.Date;

public class Blah implements Serializable {
    private String username;
    private Date date;
    private String txt;

    public Blah(){}

    public Blah(String username, Date date,String txt){
        this.username = username;
        this.date = date;
        this.txt = txt;
    }

    public String getUsername(){
        return username;
    }

    public Date getDate(){
        return date;
    }

    public String getTxt(){
        return txt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
