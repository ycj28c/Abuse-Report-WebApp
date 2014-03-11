package mvc.dao;

import mvc.vo.Attach;
import mvc.vo.Report;

public interface IAttachDAO {
	public boolean saveFile(Attach attach) throws Exception;
	public boolean deleteFileByPath(Attach attach) throws Exception;
	public boolean deleteEmptyReportId(Attach attach, String prjPath) throws Exception;
	public boolean setReportId(Report report) throws Exception;
}
