package ro.cerner.envdashboard.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CheckerPropertiesRecordMapper implements RowMapper<CheckerPropertiesRecord> {

	@Override
	public CheckerPropertiesRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
		CheckerPropertiesRecord checkerPropertiesRecord = new CheckerPropertiesRecord();
		checkerPropertiesRecord.setId(rs.getInt("id"));
		checkerPropertiesRecord.setCheckerDefinitionId(rs.getInt("checkerDefinitionId"));
		checkerPropertiesRecord.setFieldName(rs.getString("fieldName"));
		checkerPropertiesRecord.setFieldValue(rs.getString("fieldValue"));
		checkerPropertiesRecord.setPosition(rs.getInt("position"));
		return checkerPropertiesRecord;
	}

}
