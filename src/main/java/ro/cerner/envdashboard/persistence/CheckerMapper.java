package ro.cerner.envdashboard.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.cerner.envdashboard.persistence.model.Checker;

public class CheckerMapper implements RowMapper<Checker> {

	@Override
	public Checker mapRow(ResultSet rs, int rowNum) throws SQLException {
		Checker machine = new Checker();
		machine.setId(rs.getInt("Id"));
		machine.setCheckerTypeId(rs.getInt("CheckerTypeId"));
		machine.setEnvironmentId(rs.getInt("EnvironmentId"));
		machine.setMachineId(rs.getInt("MachineId"));
		return machine;
	}
}
