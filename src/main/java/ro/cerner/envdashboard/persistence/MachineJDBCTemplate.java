package ro.cerner.envdashboard.persistence;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MachineJDBCTemplate implements MachineDAO {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, String IP, String gateway) {
		String SQL = "insert into Machine (Name, IP, Gateway) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL, name, IP, gateway);
		System.out.println("Created Record Name = " + name + " IP = " + IP + " Gateway = " + gateway);
	}

	@Override
	public Machine getMachine(Integer id) {
		String SQL = "select * from Machine where Id = ?";
		Machine machine = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new MachineMapper());
		return machine;
	}

	@Override
	public List<Machine> getMachines() {
		String SQL = "select * from Machine";
		List<Machine> machines = jdbcTemplateObject.query(SQL, new MachineMapper());
		return machines;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Machine where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	@Override
	public void update(Integer id, String name, String IP, String gateway) {
		String SQL = "update Machine set Name = ?, IP = ?, Gateway = ? where id = ?";
		jdbcTemplateObject.update(SQL, name, IP, gateway, id);
		System.out.println("Updated Record with ID = " + id);
	}

}
