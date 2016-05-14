package ro.cerner.envdashboard.persistence;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EnvironmentJDBCTemplate implements EnvironmentDAO{

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, String description, Date lastChecked, Boolean status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Environment getEnvironment(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Environment> getEnvironments() {
		String SQL = "select * from Environment";
		List<Environment> environments = jdbcTemplateObject.query(SQL, new EnvironmentMapper());
		return environments;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Integer id, String name, String description, Date lastChecked, Boolean status) {
		// TODO Auto-generated method stub
		
	}

}
