package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import mvc.vo.Disposition;

public class DispositionDAOImpl implements IDispositionDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象
	
	public DispositionDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	public int addDisposition(Disposition disposition) throws Exception {
		int PKdisposition = 0;
		try {
			String sql = "INSERT INTO disposition (reportid, investigationid, description, attacholdname, " +
					"attachnewname, attachpath ) VALUES (?, ?, ?, ?, ?, ?)";
			
			//System.out.println("disposition.getReportid():"+disposition.getReportid());
			//System.out.println("disposition.getInvestigationid():"+disposition.getInvestigationid());
			//System.out.println("disposition.getDescription():"+disposition.getDescription());
			//System.out.println("disposition.getAttacholdname():"+disposition.getAttacholdname());
			//System.out.println("disposition.getDescription():"+disposition.getAttachnewname());
			//System.out.println("disposition.getAttachpath():"+disposition.getAttachpath());
			
			this.pstmt = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			this.pstmt.setString(1, disposition.getReportid());
			this.pstmt.setString(2, disposition.getInvestigationid());
			this.pstmt.setString(3, disposition.getDescription());
			this.pstmt.setString(4, disposition.getAttacholdname());
			this.pstmt.setString(5, disposition.getAttachnewname());
			this.pstmt.setString(6, disposition.getAttachpath());
			this.pstmt.executeUpdate();
			ResultSet rs = this.pstmt.getGeneratedKeys(); 
			if(rs.next()){
				PKdisposition = rs.getInt(1);
	        }else {
	        	PKdisposition = 0;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return PKdisposition;
	}

	public Disposition getDispositionById(Disposition disposition) throws Exception {
		String sql = "select reportid,investigationid,description,attacholdname,attachnewname,attachpath" +
				" from disposition where PK_disposition=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, disposition.getPkDisposition());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			disposition.setReportid(rs.getString("reportid"));
			disposition.setInvestigationid(rs.getString("investigationid"));
			disposition.setDescription(rs.getString("description"));
			disposition.setAttacholdname(rs.getString("attacholdname"));
			disposition.setAttachnewname(rs.getString("attachnewname"));
			disposition.setAttachpath(rs.getString("attachpath"));		
		}
		return disposition;
	}
}
