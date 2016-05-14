package ro.cerner.envdashboard.persistence.dao;

import java.util.List;

import javax.sql.DataSource;

import ro.cerner.envdashboard.persistence.model.CheckerDefinition;

public interface CheckerDefinitionDAO {

	public void setDataSource(DataSource ds);
	
	public void create(int fieldLength, String fieldName,
			String fieldType, int position, long checkerTypeId);
	
	public CheckerDefinition getCheckerDefinition(Integer id);
	
	public List<CheckerDefinition> getCheckerDefinitions();
	
	public void delete(Integer id);
	
	public void update(Integer id, int fieldLength, String fieldName,
			String fieldType, int position, long checkerTypeId);
}
 