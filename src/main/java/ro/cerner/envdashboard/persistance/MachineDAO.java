package ro.cerner.envdashboard.persistance;

import java.util.List;

import javax.sql.DataSource;

public interface MachineDAO {

	public void setDataSource(DataSource ds);

	public void create(String name, String IP, String gateway);

	public Machine getMachine(Integer id);

	public List<Machine> getMachines();

	public void delete(Integer id);

	public void update(Integer id, String name, String IP, String gateway);

}
