package Connection_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabseTest {
	static IDatabaseConnection SQLServer = new SQLServerPool();
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		SQLServer.init();
		long start = System.currentTimeMillis();
        for(int i=0; i<500; i++) {
        	executePool();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用连接池花费的时间(500个):"+(end-start)+ "ms");
        
        start=System.currentTimeMillis();
        SQLServerHandler handler = new SQLServerHandler();
        for (int i = 0; i <100; i++) {
        	executeNormal(handler);
        }
        end = System.currentTimeMillis();
        System.out.println("不使用连接池花费的时间(100个):"+ (end- start) + "ms");
	}

	private static void executePool() {
        try{
            Connection conn = SQLServer.getConnection();
            String sql = "select * from students";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            //System.out.println(rs);
            pst.close();
            SQLServer.returnConnection(conn);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	private static void executeNormal(SQLServerHandler handler) throws SQLException {
		Connection conn = handler.buildConnection();
		String sql = "select * from students";
		PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        //System.out.println(rs);
        handler.close(conn, stmt, rs);
	}
}
