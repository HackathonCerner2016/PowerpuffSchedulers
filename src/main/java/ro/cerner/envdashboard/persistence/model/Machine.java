package ro.cerner.envdashboard.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Machine database table.
 * 
 */
@Entity
@NamedQuery(name="Machine.findAll", query="SELECT m FROM Machine m")
public class Machine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	@Column(name="Gateway")
	private Object gateway;

	@Column(name="IP")
	private Object ip;

	@Column(name="Name")
	private Object name;

	//bi-directional many-to-one association to ToBeRenamedChecker
	@OneToMany(mappedBy="machine")
	private List<Checker> checkers;

	public Machine() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object getGateway() {
		return this.gateway;
	}

	public void setGateway(Object gateway) {
		this.gateway = gateway;
	}

	public Object getIp() {
		return this.ip;
	}

	public void setIp(Object ip) {
		this.ip = ip;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public List<Checker> getCheckers() {
		return this.checkers;
	}

	public void setToBeRenamedCheckers(List<Checker> checkers) {
		this.checkers = checkers;
	}

	public Checker addChecker(Checker checker) {
		getCheckers().add(checker);
		checker.setMachine(this);

		return checker;
	}

	public Checker removeChecker(Checker checker) {
		getCheckers().remove(checker);
		checker.setMachine(null);

		return checker;
	}

}