package ro.cerner.envdashboard.persistence.jdbc;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ro.cerner.envdashboard.persistence.dao.EnvironmentDAO;
import ro.cerner.envdashboard.persistence.mapper.CheckerPropertiesRecord;
import ro.cerner.envdashboard.persistence.mapper.CheckerPropertiesRecordMapper;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecord;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecordMapper;
import ro.cerner.envdashboard.persistence.mapper.EnvironmentMapper;
import ro.cerner.envdashboard.persistence.model.Environment;
 
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
		String SQL = "insert into Environment (Name, Description, LastChecked, Status) values (?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, name, description, lastChecked, status);
		System.out.println("Created Record Name = " + name + " Description = " + description + " LastChecked = " + lastChecked + " Status = " + status);
	}

	@Override
	public Environment getEnvironment(Integer id) {
		String SQL = "select * from Environment where Id = ?";
		Environment environment = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new EnvironmentMapper());
		return environment;
	}
	
	

	@Override
	public List<Environment> getEnvironments() {
		String SQL = "select * from Environment";
		List<Environment> environments = jdbcTemplateObject.query(SQL, new EnvironmentMapper());
		return environments;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Environment where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	@Override
	public void update(Integer id, String name, String description, Date lastChecked, Boolean status) {
		String SQL = "update Environment set Name = ?, Description = ?, LastChecked = ?, Status = ? where id = ?";
		jdbcTemplateObject.update(SQL, name, description, lastChecked, status, id);
		System.out.println("Updated Record with ID = " + id);
	}

	@Override
	public List<CheckerRecord> getCheckersByEnvironmentId(Integer environmentId) {
		String SQL = "select c.id, c.checkerTypeId, ct.name, c.environmentId, c.machineId from Checker c inner join CheckerType ct on ct.id = c.checkerTypeId where c.environmentId = ?";
		List<CheckerRecord> environments = jdbcTemplateObject.query(SQL, new Object[] { environmentId }, new CheckerRecordMapper());
		if (environments!= null && environments.size() > 0) {
			for (CheckerRecord checkerRecord : environments) {
				checkerRecord.setCheckerPropertiesRecordList(getCheckersPropertiesByCheckerIds(checkerRecord.getId()+""));
			}
		}
		return environments;
	}

	@Override
	public List<CheckerPropertiesRecord> getCheckersPropertiesByCheckerIds(String checkerId) {
		String SQL = "select cd.id, cd.checkerDefinitionId, cdef.fieldName, cd.fieldValue, cdef.position from checkerDetails cd inner join checkerDefinition cdef on cd.checkerDefinitionId = cdef.id where cd.checkerId = ? order by cd.id";
		List<CheckerPropertiesRecord> environments = jdbcTemplateObject.query(SQL, new Object[] { checkerId }, new CheckerPropertiesRecordMapper());
		return environments;
	}

}
