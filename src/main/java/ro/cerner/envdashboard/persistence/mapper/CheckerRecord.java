package ro.cerner.envdashboard.persistence.mapper;

public class CheckerRecord {

	private Integer id;
	private Integer checkerTypeId;
	private String checkerTypeName;
	private Integer environmentId;
	private Integer machineId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCheckerTypeId() {
		return checkerTypeId;
	}
	public void setCheckerTypeId(Integer checkerTypeId) {
		this.checkerTypeId = checkerTypeId;
	}
	public String getCheckerTypeName() {
		return checkerTypeName;
	}
	public void setCheckerTypeName(String checkerTypeName) {
		this.checkerTypeName = checkerTypeName;
	}
	public Integer getEnvironmentId() {
		return environmentId;
	}
	public void setEnvironmentId(Integer environmentId) {
		this.environmentId = environmentId;
	}
	public Integer getMachineId() {
		return machineId;
	}
	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}
	
}
