package ro.cerner.envdashboard.persistence.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ro.cerner.envdashboard.persistence.dao.CheckerDAO;
import ro.cerner.envdashboard.persistence.mapper.CheckerMapper;
import ro.cerner.envdashboard.persistence.model.Checker;

public class CheckerJDBCTemplate implements CheckerDAO {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(long checkerTypeId, long environmentId, long machineId) {
		String SQL = "insert into Checker (CheckerTypeId, EnvironmentId, MachineId) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL, checkerTypeId, environmentId, machineId);
		System.out.println("Created Record CheckerTypeId = " + checkerTypeId + " EnvironmentId = " + environmentId + " MachineId = " + machineId);
		
	}

	@Override
	public Checker getChecker(Integer id) {
		String SQL = "select * from Checker where Id = ?";
		Checker checker = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new CheckerMapper());
		return checker;
	}

	@Override
	public List<Checker> getCheckers() {
		String SQL = "select * from Checker";
		List<Checker> checkers = jdbcTemplateObject.query(SQL, new CheckerMapper());
		return checkers;
	}

	@Override
	public void update(Integer id, long checkerTypeId, long environmentId,
			long machineId) {
		String SQL = "update Checker CheckerTypeId = ?, EnvironmentId = ?, MachineId = ? where id = ?";
		jdbcTemplateObject.update(SQL, checkerTypeId, environmentId, machineId, id);
		System.out.println("Updated Record with ID = " + id);
		
	}
	
	@Override
	public void delete(Integer id) {
		String SQL = "delete from Checker where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}
}
