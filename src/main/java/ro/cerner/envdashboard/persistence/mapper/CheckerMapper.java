package ro.cerner.envdashboard.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.cerner.envdashboard.persistence.model.Checker;

public class CheckerMapper implements RowMapper<Checker> {

	@Override
	public Checker mapRow(ResultSet rs, int rowNum) throws SQLException {
		Checker checker = new Checker();
		checker.setId(rs.getInt("Id"));
		checker.setCheckerTypeId(rs.getInt("CheckerTypeId"));
		checker.setEnvironmentId(rs.getInt("EnvironmentId"));
		checker.setMachineId(rs.getInt("MachineId"));
		return checker;
	}
}
