package mvc.dao;

import mvc.vo.Disposition;

public interface IDispositionDAO {
	public int addDisposition(Disposition disposition) throws Exception;
	public Disposition getDispositionById(Disposition disposition) throws Exception;
	public boolean updateDisposition(Disposition disposition) throws Exception;
	public boolean updateDispositionWithoutAttach(Disposition disposition) throws Exception;
}

