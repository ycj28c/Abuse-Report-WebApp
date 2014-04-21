package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import mvc.vo.Patient;

public class PatientDAOImpl implements IPatientDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象

	public PatientDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}
	public int addPatient(Patient patient) throws Exception {
		int patientid = 0;
		try {
			String sql = "INSERT INTO patient (`name`, `address`, `age`, `sex`, " +
					"`telephone`, `DOB`, `mar_stat`, `comm_need`, `serv_by`, `serv_type`, `ethnicity`, `disability`," +
					" `coll_contact`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			this.pstmt = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);// 实例化操作
			this.pstmt.setString(1, patient.getName());
			this.pstmt.setString(2, patient.getAddress());
			this.pstmt.setInt(3, patient.getAge());
			this.pstmt.setString(4, patient.getSex());
			this.pstmt.setString(5, patient.getTelephone());
			this.pstmt.setString(6, patient.getDob());
			this.pstmt.setString(7, patient.getMarStat());
			this.pstmt.setString(8, patient.getCommNeed());
			this.pstmt.setString(9, patient.getServBy());
			this.pstmt.setString(10, patient.getServType());
			this.pstmt.setString(11, patient.getEthnicity());
			this.pstmt.setString(12, patient.getDisability());
			this.pstmt.setString(13, patient.getCollContact());
			this.pstmt.executeUpdate();
			ResultSet rs = this.pstmt.getGeneratedKeys(); 
			if(rs.next()){
				patientid = rs.getInt(1);
	        }else {
	        	patientid = 0;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
			// throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return patientid;
	}
	public Patient getinfo(Patient victim) throws Exception {
		try {
			String sql = "select name,address,age,sex,telephone,DOB,mar_stat,comm_need,serv_by," +
					"serv_type,ethnicity,disability,coll_contact from patient where PK_patient=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, victim.getPkPatient());
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				victim.setName(rs.getString("name"));
				victim.setAddress(rs.getString("address"));
				victim.setAge(rs.getInt("age"));
				victim.setSex(rs.getString("sex"));
				victim.setTelephone(rs.getString("telephone"));
				victim.setDob(rs.getString("DOB"));
				victim.setMarStat(rs.getString("mar_stat"));
				victim.setCommNeed(rs.getString("comm_need"));
				victim.setServBy(rs.getString("serv_by"));
				victim.setServType(rs.getString("serv_type"));
				victim.setEthnicity(rs.getString("ethnicity"));
				victim.setDisability(rs.getString("disability"));
				victim.setCollContact(rs.getString("coll_contact"));
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
		return victim;
	}

}
