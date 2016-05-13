package ro.cerner.envdashboard.businesslogic;

import static ro.cerner.envdashboard.businesslogic.CheckStatus.FAILURE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Environment implements Checker{

	private long id;
	
	private String name;
	
	private String description;
	
	private Date lastChecked;
	
	//last status 
	private CheckResult lastCheckResult;
	
	private final List<Checker> checkersList = new ArrayList<>();
	
	public Environment(long id, String name, String description, Date lastChecked, CheckResult status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.lastChecked = lastChecked;
		this.lastCheckResult = status;
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

	public CheckResult getLastCheckResult() {
		return lastCheckResult;
	}

	public void setLastCheckResult(CheckResult status) {
		this.lastCheckResult = status;
	}
	
	public List<Checker> getCheckersList() {
		return checkersList;
	}
	
	@Override
	public String toString() {
		return "Environment [id=" + id + ", name=" + name + ", description=" + description + ", lastChecked="
				+ lastChecked + ", lastCheckResult=" + lastCheckResult + "]";
	}

	@Override
	public CheckResult check() {
		
		CheckStatus status = FAILURE;
		
		for(Checker checker : this.getCheckersList()){
    		CheckResult checkResult = checker.check();
    		
    		//insert into db
    		
    		if(checkResult.status.equals(FAILURE)){
    			lastCheckResult = new CheckResult(FAILURE, "At least one check failed!");
    		}
    	}
		
		
		
		return lastCheckResult;
	}
	
}
