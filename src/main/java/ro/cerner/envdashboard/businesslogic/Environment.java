package ro.cerner.envdashboard.businesslogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Environment {

	private long id;
	
	private String name;
	
	private String description;
	
	private Date lastChecked;
	
	//last status 
	private CheckResult status;
	
	private final List<Checker> checkersList = new ArrayList<>();
	
	public Environment(long id, String name, String description, Date lastChecked, CheckResult status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.lastChecked = lastChecked;
		this.status = status;
	}

	public Environment(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getLastChecked() {
		return lastChecked;
	}

	public void setLastChecked(Date lastChecked) {
		this.lastChecked = lastChecked;
	}

	public CheckResult getStatus() {
		return status;
	}

	public void setStatus(CheckResult status) {
		this.status = status;
	}
	
	public List<Checker> getCheckersList() {
		return checkersList;
	}
	
	@Override
	public String toString() {
		return "Environment [id=" + id + ", name=" + name + ", description=" + description + ", lastChecked="
				+ lastChecked + ", status=" + status + "]";
	}
	
}
