package ro.cerner.envdashboard.persistence.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.cerner.envdashboard.persistence.model.Environment;

public class EnvironmentMapper implements RowMapper<Environment> {

	@Override
	public Environment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Environment environment = new Environment();
		environment.setId(rs.getInt("Id"));
		environment.setName(rs.getString("Name"));
		environment.setDescription(rs.getString("Description"));
		environment.setLastChecked(new Date(rs.getTimestamp("LastChecked").getTime()));
		String status = rs.getString("Status");
		Boolean b = null;
		if ("1".equals(status)) { 
			b = Boolean.TRUE;
		} else if ("0".equals(status)) { 
			b = Boolean.FALSE;
		}
		environment.setStatus(b);
		return environment;
	}

}
