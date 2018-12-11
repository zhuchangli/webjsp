package cc.openhome.model;/*
 * created by on 12/10/18
 */

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlahDAOJdbcImpl implements BlahDAO{
    private DataSource dataSource;

    public BlahDAOJdbcImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Blah> getBlahs(Blah blah) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        List<Blah> blahs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT date, txt FROM t_blah WHERE name = ?");
            stmt.setString(1,blah.getUsername());
            ResultSet rs = stmt.executeQuery();
            blahs = new ArrayList<Blah>();
            while (rs.next()){
                blahs.add(new Blah(
                        blah.getUsername(),
                        rs.getTimestamp(1),
                        rs.getString(2)));
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
        return blahs;
    }

    @Override
    public void addBlah(Blah blah) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(
                    "INSERT INTO t_blah(name,date,txt) VALUES (?,?,?)");
            stmt.setString(1,blah.getUsername());
            stmt.setString(2,new Timestamp(blah.getDate().getTime()).toString());
            stmt.setString(3,blah.getTxt());
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
    public void deleteBlah(Blah blah) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        try{
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(
                    "DELETE FROM t_blah WHERE date = ?");
            stmt.setTimestamp(1,new Timestamp(blah.getDate().getTime()));
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
