package ro.cerner.envdashboard.persistence.dao;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import ro.cerner.envdashboard.persistence.model.CheckerResult;

public interface CheckerResultDAO {

public void setDataSource(DataSource ds);
	
	public void create(String message, boolean status, Date timeStamp,
			long checkerId);
	
	public CheckerResult getCheckerResult(Integer id);
	
	public List<CheckerResult> getCheckerResults();
	
	public void delete(Integer id);
	
	public void update(Integer id, String message, boolean status, Date timeStamp,
			long checkerId);
	
	
	
}
