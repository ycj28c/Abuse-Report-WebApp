package mvc.dao;

import mvc.vo.Respond;

public interface IRespondDAO {
	public int addRespond(Respond respond) throws Exception;
	public Respond getRespondById(Respond respond) throws Exception;
}

