package ro.cerner.envdashboard.persistence.dao;

import java.util.List;

import javax.sql.DataSource;

import ro.cerner.envdashboard.persistence.model.Machine;

public interface MachineDAO {

	public void setDataSource(DataSource dataSource);

	public void create(String name, String IP, String gateway);

	public Machine getMachine(Integer id);

	public List<Machine> getMachines();

	public void delete(Integer id);

	public void update(Integer id, String name, String IP, String gateway);

}
