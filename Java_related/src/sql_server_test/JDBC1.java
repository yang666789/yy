package sql_server_test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=teaching";
	private static final String USERNAME="sa";
	private static final String PASSWORD="yangyishiwo0413";
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("驱动成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//打印表
	public static void printList(Statement state) throws SQLException {
		ResultSet res=state.executeQuery("Select*From student");
		System.out.println("表格数据："+"\r\n"+
				"sno"+"\t"+"sname"+"\t"+"ssex"+"\t"+"sage"+"\t"
		+"en_time"+"\t"+"specialty"+"\t"+"grade"+"\t"+"备注");
		//用指示器遍历得到原表数据
		while(res.next()) {
			System.out.println(res.getString("sno")+
					"\t"+res.getString("sname")+"\t"+
					res.getString("ssex")+"\t"+
					res.getInt("sage")+"\t"+
					res.getDate("en_time")+"\t"+
					res.getString("specialty")+"\t"+
					res.getString("grade")+"\t"+
					res.getString("备注")
					);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection(URL, USERNAME,PASSWORD);
			System.out.println("连接成功");
			Statement sta=con.createStatement();
		 //执行插入操作
			String sql="insert into student(sno,sname,ssex,specialty,grade)values('1727302','小一','女','物联网','10级')";
            sta.executeUpdate(sql);  
			String sql1="insert into student(sno,sname,ssex,specialty,grade)values('1907302','小二','男','计科','17级')";
			sta.executeUpdate(sql1);
			String sql2="insert into student(sno,sname,ssex,specialty,grade)values('2907302','小三','女','网络','15级')";
			sta.executeUpdate(sql2);
			System.out.println("插入完成");
		 //执行更新操作
            String sql3="update student set sname ='小明(更新)' where sno =2907302";
            sta.executeUpdate(sql3); 
			System.out.println("更新完成");
         // 执行删除操作
            String sql4="delete from student where sname='小二'";
            sta.executeUpdate(sql4);
			System.out.println("删除完成");

            printList(sta);
            System.out.println("数据库操作完成END");
			sta.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
}
