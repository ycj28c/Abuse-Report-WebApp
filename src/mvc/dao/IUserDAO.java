//定义一个登陆验证的方法,这个方法为执行查询操作，并且采用了findXxx()的命名形式 
package mvc.dao;

import mvc.vo.User; //引用mvc.vo包里面的User类 

public interface IUserDAO {
	/**
	 * 用户登录验证
	 * 
	 * @param user
	 *            传入VO对象
	 * @param 验证的操作结果
	 * @throw Exception
	 */
	public boolean findLogin(User user) throws Exception;
	public User getInfo(User reporter) throws Exception;
	public User getInfoByName(User abuser) throws Exception;
}