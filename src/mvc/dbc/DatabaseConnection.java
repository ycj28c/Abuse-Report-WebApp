//负责数据库的打开与关闭操作 
package mvc.dbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
	private static String DBdriver = null;
	private static String DBURL = null;
	private static String DBUSER = null;
	private static String DBPASS = null;
	private static String configname = "config.properties";
	private Connection conn = null;
	//below is db4free online mysql database(Denmark) 
	/*db4free
	private static final String DBURL = "jdbc:mysql://www.db4free.net:3306/cs509"; 
	private static final String DBUSER = "cs509"; 
	private static final String DBPASS ="509123"; */
	/*localhost
	private static final String DBdriver = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/51test";
	private static final String DBUSER = "root";
	private static final String DBPASS = "1234";*/
	/*zhouhao's
	private static final String DBdriver = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://cs509.wpilife.org:3306/cs509_team2";
	private static final String DBUSER = "team2";
	private static final String DBPASS = "CS509TM2";*/
	
	public void GetDBFromXML() throws Exception{
		//read file in WEB-INF
		try {
			String path = DatabaseConnection.class.getResource("/").getPath();  
	        String websiteURL = (path.replace("/build/classes", "").replace("%20"," ").replace("classes/", "") + configname).replaceFirst("/", "");  
	        setParameter(websiteURL); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setParameter(String path) throws Exception{
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
			DBdriver = properties.getProperty("database.driverClassName");
			DBURL = properties.getProperty("database.url");
			DBUSER = properties.getProperty("database.username");
			DBPASS = properties.getProperty("database.password");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileInputStream.close();
		}
	}
	
	public DatabaseConnection() throws Exception { // 在构造方法中进行数据库连接
		try {
			GetDBFromXML();
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