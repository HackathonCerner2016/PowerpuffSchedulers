package ro.cerner.envdashboard.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CheckerResults database table.
 * 
 */
@Entity
@Table(name="CheckerResults")
@NamedQuery(name="CheckerResult.findAll", query="SELECT c FROM CheckerResult c")
public class CheckerResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	@Column(name="Message")
	private Object message;

	@Column(name="Status")
	private boolean status;

	@Column(name="TimeStamp")
	private Timestamp timeStamp;

	//bi-directional many-to-one association to Checker
	@ManyToOne
	@JoinColumn(name="CheckerId")
	private Checker checker;

	public CheckerResult() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object getMessage() {
		return this.message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Checker getChecker() {
		return this.checker;
	}

	public void setChecker(Checker checker) {
		this.checker = checker;
	}

}