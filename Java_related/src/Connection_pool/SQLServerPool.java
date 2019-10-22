package Connection_pool;

import java.sql.Connection;
import java.util.LinkedList;

public class SQLServerPool implements IDatabaseConnection {
	//最小连接数
	private static final int minCount = 1;
    //最大连接数
    private static final int maxCount = 10;
    //连接池
    private static final LinkedList<Connection> pools = new LinkedList<Connection>();
    SQLServerHandler handler = new SQLServerHandler();

	@Override
	public void init() {
		// TODO Auto-generated method stub
        Connection conn = null;
        try{
            for(int i=0; i<minCount; i++) {
                conn = handler.buildConnection();
                pools.add(conn);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public synchronized Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
        if(pools.size() == 0) {
            conn = handler.buildConnection();
        } else {
            conn = pools.remove(0);
        }
		return conn;
	}

	@Override
	public synchronized void returnConnection(Connection conn) {
		// TODO Auto-generated method stub
		if(pools.size() < maxCount) {
            pools.add(conn);
        }
        //System.out.println(pools);
	}

}
