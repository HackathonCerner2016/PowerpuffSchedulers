package ro.cerner.envdashboard.persistence.model;

import java.sql.Date;


public class CheckerResult {

	private long id;
	private String message;
	private boolean status;
	private Date timeStamp;
	private Checker checker;

	public CheckerResult() {
	}
	
	public CheckerResult(String message, boolean status, Date timeStamp,
			Checker checker) {
		super();
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
		this.checker = checker;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Checker getChecker() {
		return this.checker;
	}

	public void setChecker(Checker checker) {
		this.checker = checker;
	}
	
	public long getCheckerId() {
		return this.checker.getId();
	}

	public void setCheckerId(long checkerId) {
		this.checker.setId(checkerId);
	}

}