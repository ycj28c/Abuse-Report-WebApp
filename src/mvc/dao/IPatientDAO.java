package mvc.dao;

import mvc.vo.Patient;

public interface IPatientDAO {
	public int addPatient(Patient patient) throws Exception;
}
