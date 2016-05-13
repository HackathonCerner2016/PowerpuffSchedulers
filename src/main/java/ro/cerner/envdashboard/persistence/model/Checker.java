package ro.cerner.envdashboard.persistence.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ToBeRenamedChecker database table.
 * 
 */
@Entity
@NamedQuery(name="Checker.findAll", query="SELECT t FROM Checker t")
public class Checker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	//bi-directional many-to-one association to CheckerType
	@ManyToOne
	@JoinColumn(name="CheckerTypeId")
	private CheckerType checkerType;

	//bi-directional many-to-one association to Environment
	@ManyToOne
	@JoinColumn(name="EnvironmentId")
	private Environment environment;

	//bi-directional many-to-one association to Machine
	@ManyToOne
	@JoinColumn(name="MachineId")
	private Machine machine;

	public Checker() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CheckerType getCheckerType() {
		return this.checkerType;
	}

	public void setCheckerType(CheckerType checkerType) {
		this.checkerType = checkerType;
	}

	public Environment getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Machine getMachine() {
		return this.machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

}