package ro.cerner.envdashboard.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.cerner.envdashboard.persistence.model.CheckerDefinition;

public class CheckerDefinitionMapper implements RowMapper<CheckerDefinition> {

	@Override
	public CheckerDefinition mapRow(ResultSet rs, int rowNum) throws SQLException {
		CheckerDefinition checkerDefinition = new CheckerDefinition();
		checkerDefinition.setId(rs.getInt("Id"));
		checkerDefinition.setFieldLength(rs.getInt("FieldLength"));
		checkerDefinition.setFieldName(rs.getString("FieldName"));
		checkerDefinition.setFieldType(rs.getString("FieldType"));
		checkerDefinition.setPosition(rs.getInt("Position"));
		checkerDefinition.setCheckerTypeId(rs.getLong("CheckerTypeId"));
		return checkerDefinition;
	}
}
