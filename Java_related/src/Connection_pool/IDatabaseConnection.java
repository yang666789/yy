package Connection_pool;

import java.sql.Connection;

public interface IDatabaseConnection {
	//初始化
    public void init();
    //取得连接
    public  Connection getConnection();
    //关闭
    public void returnConnection(Connection conn);
}
