package ro.cerner.envdashboard.persistence;

import java.util.Date;

public class Environment {

	private Integer id;
	private String name;
	private String description;
	private Date lastChecked;
	private Boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLastChecked() {
		return lastChecked;
	}
	public void setLastChecked(Date lastChecked) {
		this.lastChecked = lastChecked;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
