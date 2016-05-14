package ro.cerner.envdashboard.persistence.dao;

import java.util.List;

import javax.sql.DataSource;

import ro.cerner.envdashboard.persistence.model.Checker;

public interface CheckerDAO {

	public void setDataSource(DataSource ds);
	
	public void create(long checkerTypeId, long environmentId,
			long machineId);
	
	public Checker getChecker(Integer id);
	
	public List<Checker> getCheckers();
	
	public void delete(Integer id);
	
	public void update(Integer id, long checkerTypeId, long environmentId,
			long machineId);

}
