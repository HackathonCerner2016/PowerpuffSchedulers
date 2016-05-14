package ro.cerner.envdashboard.persistence.dao;

import java.util.List;

import javax.sql.DataSource;

import ro.cerner.envdashboard.persistence.mapper.CheckerPropertiesRecord;

public interface CheckerPropertiesRecordDAO {

	public void setDataSource(DataSource dataSource);
	
	public List<CheckerPropertiesRecord> getCheckerPropertiesRecord();
}
