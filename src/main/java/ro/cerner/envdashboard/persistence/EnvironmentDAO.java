package ro.cerner.envdashboard.persistence;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;


public interface EnvironmentDAO {
	
	public void setDataSource(DataSource ds);

	public void create(String name, String description, Date lastChecked, Boolean status);

	public Environment getEnvironment(Integer id);

	public List<Environment> getEnvironments();

	public void delete(Integer id);

	public void update(Integer id, String name, String description, Date lastChecked, Boolean status);
}
 