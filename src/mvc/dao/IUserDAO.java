//����һ����½��֤�ķ���,�������Ϊִ�в�ѯ���������Ҳ�����findXxx()��������ʽ 
package mvc.dao;

import mvc.vo.User; //����mvc.vo�������User�� 

public interface IUserDAO {
	/**
	 * �û���¼��֤
	 * 
	 * @param user
	 *            ����VO����
	 * @param ��֤�Ĳ������
	 * @throw Exception
	 */
	public boolean findLogin(User user) throws Exception;
	public User getInfo(User reporter) throws Exception;
	public User getInfoByName(User abuser) throws Exception;
}