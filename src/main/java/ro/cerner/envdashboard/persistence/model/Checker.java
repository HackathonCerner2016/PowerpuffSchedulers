package ro.cerner.envdashboard.persistence.model;

public class Checker {

	private long id;
	private long checkerTypeId;
	private long environmentId;
	private long machineId;
	
	public Checker() {
	}
	
	

	public Checker(long checkerTypeId, long environmentId,
			long machineId) {
		super();
		this.checkerTypeId = checkerTypeId;
		this.environmentId = environmentId;
		this.machineId = machineId;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCheckerTypeId() {
		return checkerTypeId;
	}

	public void setCheckerTypeId(long checkerTypeId) {
		this.checkerTypeId = checkerTypeId;
	}

	public long getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(long environmentId) {
		this.environmentId = environmentId;
	}

	public long getMachineId() {
		return machineId;
	}

	public void setMachineId(long machineId) {
		this.machineId = machineId;
	}

}