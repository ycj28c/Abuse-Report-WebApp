package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Patient;

public class PatientDAOProxy implements IPatientDAO {
	private DatabaseConnection dbc = null;// 定义数据库连接
	private IPatientDAO dao = null;// 定义DAO接口

	public PatientDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new PatientDAOImpl(this.dbc.getConnection());
	}

	public int addPatient(Patient patient) throws Exception {
		int patientid = 0;
		try {
			patientid = this.dao.addPatient(patient);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return patientid;
	}

	public Patient getinfo(Patient victim) throws Exception {
		try {
			victim = this.dao.getinfo(victim);// 调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return victim;
	}

}