package ro.cerner.envdashboard.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.cerner.envdashboard.persistence.model.CheckerResult;

public class CheckerResultMapper implements RowMapper<CheckerResult> {

	@Override
	public CheckerResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		CheckerResult checkerResult = new CheckerResult();
		checkerResult.setId(rs.getInt("Id"));
		checkerResult.setMessage(rs.getString("Message"));
		checkerResult.setStatus(rs.getBoolean("Status"));
		checkerResult.setTimeStamp(new Date(rs.getTimestamp("TimeStamp").getTime()));
		checkerResult.setCheckerId(rs.getInt("CheckerId"));
		return checkerResult;
	}

}
