//定义实现类,在此类中将通过输入用户ID和密码进行验证， 
//如果验证成功，则通过VO将用户的真实姓名取出并返回 
package mvc.dao;

import java.sql.*;

import mvc.dao.IUserDAO;
import mvc.vo.User;

public class UserDAOImpl implements IUserDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象

	public UserDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "select name, groupid from user where userid=? and password=?";
			this.pstmt = this.conn.prepareStatement(sql);// 实例化操作
			this.pstmt.setString(1, user.getUserid());// 设置id
			this.pstmt.setString(2, user.getPassword());// 设置密码
			ResultSet rs = this.pstmt.executeQuery();// 取得查询结果
			if (rs.next()) {
				user.setName(rs.getString(1));// 取得姓名
				user.setGroupid(rs.getString(2));// 取得groupid
				flag = true;// 登录成功
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// 关闭操作
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	public User getInfo(User reporter) throws Exception {
		try {
			String sql = "select userid,name,password,address,telephone,mandated," +
					"SSN, DOB from user where userid=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, reporter.getUserid());
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				reporter.setName(rs.getString("name"));
				reporter.setPassword(rs.getString("password"));
				reporter.setAddress(rs.getString("address"));
				reporter.setTelephone(rs.getString("telephone"));
				reporter.setMandated(rs.getString("mandated"));
				reporter.setSSN(rs.getString("SSN"));
				reporter.setDOB(rs.getString("DOB"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return reporter;
	}

	public User getInfoByName(User abuser) throws Exception {
		try {
			String sql = "select userid,name,password,address,telephone,mandated," +
					"SSN, DOB from user where name=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, abuser.getName());
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				abuser.setUserid(rs.getString("userid"));
				abuser.setPassword(rs.getString("password"));
				abuser.setAddress(rs.getString("address"));
				abuser.setTelephone(rs.getString("telephone"));
				abuser.setMandated(rs.getString("mandated"));
				abuser.setSSN(rs.getString("SSN"));
				abuser.setDOB(rs.getString("DOB"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return abuser;
	}
}