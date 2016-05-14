package ro.cerner.envdashboard.persistence.model;

import java.util.List;

public class CheckerType {
	
	private long id;
	private Object name;
	private List<CheckerDefinition> checkerDefinitions;
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

	public List<Checker> getCheckers() {
		return this.checkers;
	}

	public void setCheckers(List<Checker> checkers) {
		this.checkers = checkers;
	}

}