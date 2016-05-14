package ro.cerner.envdashboard.persistence.jdbc;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ro.cerner.envdashboard.persistence.dao.CheckerResultDAO;
import ro.cerner.envdashboard.persistence.mapper.CheckerResultMapper;
import ro.cerner.envdashboard.persistence.model.CheckerResult;

public class CheckerResultJDBCTemplate implements CheckerResultDAO {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void create(String message, boolean status, Date timeStamp,
			long checkerId) {
		String SQL = "insert into CheckerResults (Message, Status, TimeStamp, CheckerId) values (?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, message, status, timeStamp, checkerId);
		System.out.println("Created Record Message = " + message + " Status = " + status + " TimeStamp = " + timeStamp + " CheckerId = " + checkerId);
		
	}

	@Override
	public CheckerResult getCheckerResult(Integer id) {
		String SQL = "select * from CheckerResults where Id = ?";
		CheckerResult CheckerResult = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new CheckerResultMapper());
		return CheckerResult;
	}

	@Override
	public List<CheckerResult> getCheckerResults() {
		String SQL = "select * from CheckerResults";
		List<CheckerResult> checkerResults = jdbcTemplateObject.query(SQL, new CheckerResultMapper());
		return checkerResults;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from CheckerResults where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		
	}

	@Override
	public void update(Integer id, String message, boolean status,
			Date timeStamp, long checkerId) {
		String SQL = "update CheckerResults set Message = ?, Status = ?, TimeStamp = ?, CheckerId = ? where id = ?";
		jdbcTemplateObject.update(SQL, message, status, timeStamp, checkerId, id);
		System.out.println("Updated Record with ID = " + id);
		
	}
	

}
