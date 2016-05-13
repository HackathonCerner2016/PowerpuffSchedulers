package ro.cerner.envdashboard.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CheckerType database table.
 * 
 */
@Entity
@NamedQuery(name="CheckerType.findAll", query="SELECT c FROM CheckerType c")
public class CheckerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	@Column(name="Name")
	private Object name;

	//bi-directional many-to-one association to CheckerDefinition
	@OneToMany(mappedBy="checkerType")
	private List<CheckerDefinition> checkerDefinitions;

	//bi-directional many-to-one association to ToBeRenamedChecker
	@OneToMany(mappedBy="checkerType")
	private List<Checker> checkers;

	public CheckerType() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public List<CheckerDefinition> getCheckerDefinitions() {
		return this.checkerDefinitions;
	}

	public void setCheckerDefinitions(List<CheckerDefinition> checkerDefinitions) {
		this.checkerDefinitions = checkerDefinitions;
	}

	public CheckerDefinition addCheckerDefinition(CheckerDefinition checkerDefinition) {
		getCheckerDefinitions().add(checkerDefinition);
		checkerDefinition.setCheckerType(this);

		return checkerDefinition;
	}

	public CheckerDefinition removeCheckerDefinition(CheckerDefinition checkerDefinition) {
		getCheckerDefinitions().remove(checkerDefinition);
		checkerDefinition.setCheckerType(null);

		return checkerDefinition;
	}

	public List<Checker> getCheckers() {
		return this.checkers;
	}

	public void setCheckers(List<Checker> checkers) {
		this.checkers = checkers;
	}

	public Checker addChecker(Checker checker) {
		getCheckers().add(checker);
		checker.setCheckerType(this);

		return checker;
	}

	public Checker removeChecker(Checker checker) {
		getCheckers().remove(checker);
		checker.setCheckerType(null);

		return checker;
	}

}