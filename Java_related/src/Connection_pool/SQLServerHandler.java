package Connection_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerHandler {
	private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=teaching";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "yangyishiwo0413";
    private Connection conn = null;
    
    public Connection buildConnection() {
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public void close(Connection conn,Statement stmt,ResultSet rs){
        //关闭ResultSet对象
        if(rs != null){
            try{
                //关闭rs，设置rs=null，因为java会优先回收值为null的变量
                rs.close();
                rs = null;
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        //关闭Statement对象,因为PrepareStatement和CallableStatement都是Statement的子接口，所以这里只需要有关闭Statement对象的方法就可以了
        if(stmt != null){
            try{
                stmt.close();
                stmt = null;
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        //关闭Connection对象
        if(conn != null){
            try{
                conn.close();
                conn = null;
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
