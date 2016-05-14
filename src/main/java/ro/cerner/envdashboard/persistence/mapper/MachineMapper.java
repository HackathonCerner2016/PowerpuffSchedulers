package ro.cerner.envdashboard.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.cerner.envdashboard.persistence.model.Machine;


public class MachineMapper implements RowMapper<Machine> 
{
	public Machine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Machine machine = new Machine();
		machine.setId(rs.getInt("Id"));
		machine.setName(rs.getString("Name"));
		machine.setIP(rs.getString("IP"));
		machine.setGateway(rs.getString("Gateway"));
		return machine;
	}
}
