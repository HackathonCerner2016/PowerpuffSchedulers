package ro.cerner.envdashboard.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EnvironmentMapper implements RowMapper<Environment> {

	@Override
	public Environment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Environment environment = new Environment();
		environment.setId(rs.getInt("Id"));
		environment.setName(rs.getString("Name"));
		environment.setDescription(rs.getString("Description"));
		environment.setLastChecked(new Date(rs.getTimestamp("LastChecked").getTime()));
		environment.setStatus(rs.getBoolean("Status"));
		return environment;
	}

}
