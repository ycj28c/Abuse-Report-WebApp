package mvc.dao;

import mvc.vo.Decision;

public interface IDecisionDAO {
	public int addDecision(Decision decision) throws Exception;
	public Decision getDecisionById(Decision decision) throws Exception;
}