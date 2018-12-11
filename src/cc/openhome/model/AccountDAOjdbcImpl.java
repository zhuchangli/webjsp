package cc.openhome.model;/*
 * created by on 12/10/18
 */

import javax.management.Query;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOjdbcImpl implements AccountDAO{
    private DataSource dataSource;

    public AccountDAOjdbcImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public boolean isUserExisted(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        boolean existed = false;
        try{
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT  COUNT(1) FROM t_account WHERE name = ?");
            stmt.setString(1,account.getName());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                existed = (rs.getInt(1) == 1);
            }
        }catch (SQLException e){
            ex = e;
        }finally {
            if(stmt != null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }
                catch (SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(ex != null){
                throw new RuntimeException(ex);
            }
        }
        return existed;
    }

    public void addAccount(Account account){
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        try{
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("INSERT INTO t_account(name,password,email) values (?,?,?)");
            stmt.setString(1,account.getName());
            stmt.setString(2,account.getPassword());
            stmt.setString(3,account.getEmail());
            stmt.executeUpdate();
        }catch (SQLException e){
            ex = e;
        }finally {
            if(stmt != null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }
                catch (SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(ex != null){
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public Account getAccount(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        Account acct = null;
        try{
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(
                    "SELECT password,email FROM t_account WHERE name = ?");
            stmt.setString(1,account.getName());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                // 查询到的账户数据封装为Account对象
                acct = new Account(account.getName(),rs.getString(1),rs.getString(2));
            }
        } catch (SQLException e){
            ex = e;
        }finally {
            if(stmt != null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }
                catch (SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(ex != null){
                throw new RuntimeException(ex);
            }
        }
        return acct;
    }

    @Override
    public void deleteAccount(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        try{
            /*
            String q = "alter table t_blah"+
            "add constraint t_blah_ibfk_13"+
            "foreign key (name) references t_account(name)"+
            "on delete cascade";
            stmt = conn.prepareStatement(q);
            */
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("DELETE FROM t_account WHERE name = ?");
            String n = account.getName();
            stmt.setString(1,account.getName());
            stmt.executeUpdate();
        }catch (SQLException e){
            ex = e;
        }finally {
            if(stmt != null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }
                catch (SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(ex != null){
                throw new RuntimeException(ex);
            }
        }
    }
}
