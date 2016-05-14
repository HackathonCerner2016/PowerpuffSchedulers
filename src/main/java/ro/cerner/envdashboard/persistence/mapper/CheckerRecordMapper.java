package ro.cerner.envdashboard.persistence.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.cerner.envdashboard.persistence.model.Environment;

public class CheckerRecordMapper implements RowMapper<CheckerRecord> {

	@Override
	public CheckerRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
		CheckerRecord checkerRecord = new CheckerRecord();
		checkerRecord.setId(rs.getInt("Id"));
		checkerRecord.setCheckerTypeId(rs.getInt("checkerTypeId"));
		checkerRecord.setCheckerTypeName(rs.getString("name"));
		checkerRecord.setEnvironmentId(rs.getInt("environmentId"));
		checkerRecord.setMachineId(rs.getInt("machineId"));
		return checkerRecord;
	}

}
