package ro.cerner.envdashboard.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Environment database table.
 * 
 */
@Entity
@NamedQuery(name="Environment.findAll", query="SELECT e FROM Environment e")
public class Environment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	@Column(name="Description")
	private Object description;

	@Column(name="LastChecked")
	private Timestamp lastChecked;

	@Column(name="Name")
	private Object name;

	@Column(name="Status")
	private boolean status;

	//bi-directional many-to-one association to ToBeRenamedChecker
	@OneToMany(mappedBy="environment")
	private List<Checker> checkers;

	public Environment() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

	public Timestamp getLastChecked() {
		return this.lastChecked;
	}

	public void setLastChecked(Timestamp lastChecked) {
		this.lastChecked = lastChecked;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Checker> getCheckers() {
		return this.checkers;
	}

	public void setCheckers(List<Checker> checkers) {
		this.checkers = checkers;
	}

	public Checker addChecker(Checker checker) {
		getCheckers().add(checker);
		checker.setEnvironment(this);

		return checker;
	}

	public Checker removeChecker(Checker checker) {
		getCheckers().remove(checker);
		checker.setEnvironment(null);

		return checker;
	}

}