package mvc.dao;

import mvc.dbc.DatabaseConnection;
import mvc.vo.Patient;

public class PatientDAOProxy implements IPatientDAO {
	private DatabaseConnection dbc = null;// �������ݿ�����
	private IPatientDAO dao = null;// ����DAO�ӿ�

	public PatientDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new PatientDAOImpl(this.dbc.getConnection());
	}

	public int addPatient(Patient patient) throws Exception {
		int patientid = 0;
		try {
			patientid = this.dao.addPatient(patient);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return patientid;
	}

	public Patient getinfo(Patient victim) throws Exception {
		try {
			victim = this.dao.getinfo(victim);// ������ʵ����
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return victim;
	}

}