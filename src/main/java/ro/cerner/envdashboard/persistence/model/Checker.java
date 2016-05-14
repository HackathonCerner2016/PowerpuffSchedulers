package ro.cerner.envdashboard.persistence.model;

public class Checker {

	private long id;
	private CheckerType checkerType;
	private long environmentId;
	private long machineId;
	
	public Checker() {
	}

	public Checker(long id, long checkerTypeId, long environmentId,
			long machineId, String checkerTypeName) {
		super();
		this.id = id;
		this.checkerType = new CheckerType(checkerTypeId, checkerTypeName);
		this.environmentId = environmentId;
		this.machineId = machineId;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CheckerType getCheckerType() {
		return checkerType;
	}

	public void setCheckerType(CheckerType checkerType) {
		this.checkerType = checkerType;
	}
	
	public long getCheckerTypeId() {
		return checkerType.getId();
	}

	public void setCheckerTypeId(long checkerTypeId) {
		this.checkerType.setId(checkerTypeId);
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