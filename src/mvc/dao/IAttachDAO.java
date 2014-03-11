package mvc.dao;

import mvc.vo.Attach;

public interface IAttachDAO {
	public boolean saveFile(Attach attach) throws Exception;
	public boolean deleteFileByPath(Attach attach) throws Exception;
}
