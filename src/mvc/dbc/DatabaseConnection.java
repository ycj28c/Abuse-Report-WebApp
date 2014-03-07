//�������ݿ�Ĵ���رղ��� 
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

	public DatabaseConnection() throws Exception { // �ڹ��췽���н������ݿ�����
		try {
			Class.forName(DBdriver).newInstance();// ������������
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);// �������ݿ�
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {// ȡ�����ݿ�����
		return this.conn;// ȡ����������
	}

	public void close() throws Exception {// �ر����ݿ����
		if (this.conn != null) {// ����NullPointerException
			try {
				this.conn.close();// �ر����ݿ�
			} catch (Exception e) {
				throw e;
			}
		}
	}
}