package cc.openhome.model;/*
 * created by on 12/10/18
 */

public class Account {
    private String name;
    private String password;
    private String email;

    public Account(String name){
        this.name = name;
    }

    // 用户登录时验证密码和用户是否正确
    public Account(String name,String password){
        this(name);
        this.password = password;
    }
    public Account(String name,String password,String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
