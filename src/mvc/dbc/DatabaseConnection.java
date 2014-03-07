//负责数据库的打开与关闭操作 
package mvc.dbc;

import java.sql.*;

public class DatabaseConnection {
	//below is db4free online mysql database(Denmark) 
	//private static final String DBURL = "jdbc:mysql://www.db4free.net:3306/cs509"; 
	//private static final String DBUSER = "cs509"; 
	//private static final String DBPASS ="509123"; 
	private static final String DBdriver = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://cs509.wpilife.org:3306/cs509_team2";
	private static final String DBUSER = "team2";
	private static final String DBPASS = "CS509TM2";
	private Connection conn = null;

	public DatabaseConnection() throws Exception { // 在构造方法中进行数据库连接
		try {
			Class.forName(DBdriver).newInstance();// 加载驱动程序
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);// 连接数据库
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {// 取得数据库连接
		return this.conn;// 取得数据连接
	}

	public void close() throws Exception {// 关闭数据库操作
		if (this.conn != null) {// 避免NullPointerException
			try {
				this.conn.close();// 关闭数据库
			} catch (Exception e) {
				throw e;
			}
		}
	}
}