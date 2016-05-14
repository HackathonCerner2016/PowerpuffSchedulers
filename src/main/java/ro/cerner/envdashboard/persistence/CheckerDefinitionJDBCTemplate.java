package ro.cerner.envdashboard.persistence;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ro.cerner.envdashboard.persistence.dao.CheckerDefinitionDAO;
import ro.cerner.envdashboard.persistence.model.CheckerDefinition;

public class CheckerDefinitionJDBCTemplate implements CheckerDefinitionDAO {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	

	
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(int fieldLength, String fieldName, String fieldType,
			int position, long checkerTypeId) {
		String SQL = "insert into CheckerDefinition (FieldLength, FieldName, FieldType, Position, CheckerTypeId) values (?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, fieldLength, fieldName, fieldType, position, checkerTypeId);
		System.out.println("Created Record FieldLength = " + fieldLength + " FieldName = " + fieldName + " FieldType = " + fieldType + " Position = " + position + " CheckerTypeId = " + checkerTypeId);
	}

	@Override
	public CheckerDefinition getCheckerDefinition(Integer id) {
		String SQL = "select * from CheckerDefinition where Id = ?";
		CheckerDefinition checkerDefinition = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new CheckerDefinitionMapper());
		return checkerDefinition;
	}

	@Override
	public List<CheckerDefinition> getCheckerDefinitions() {
		String SQL = "select * from CheckerDefinition";
		List<CheckerDefinition> checkerDefinitions = jdbcTemplateObject.query(SQL, new CheckerDefinitionMapper());
		return checkerDefinitions;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from CheckerDefinition where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	@Override
	public void update(Integer id, int fieldLength, String fieldName, String fieldType,
			int position, long checkerTypeId) {
		String SQL = "update CheckerDefinition set FieldLength = ?, FieldName = ?, FieldType = ?, Position = ?, CheckerTypeId = ? where id = ?";
		jdbcTemplateObject.update(SQL, fieldLength, fieldName, fieldType, position, checkerTypeId, id);
		System.out.println("Updated Record with ID = " + id);
		
	}

}
