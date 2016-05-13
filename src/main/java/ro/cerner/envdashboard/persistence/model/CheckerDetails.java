package ro.cerner.envdashboard.persistence.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CheckerDetails1 database table.
 * 
 */
@Entity
@NamedQuery(name="CheckerDetails.findAll", query="SELECT c FROM CheckerDetails c")
public class CheckerDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	@Column(name="FieldValue")
	private Object fieldValue;

	//bi-directional many-to-one association to Checker
	@ManyToOne
	@JoinColumn(name="CheckerId")
	private Checker checker;

	//bi-directional many-to-one association to CheckerDefinition
	@ManyToOne
	@JoinColumn(name="CheckerDefinitionId")
	private CheckerDefinition checkerDefinition;

	public CheckerDetails() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object getFieldValue() {
		return this.fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public Checker getChecker() {
		return this.checker;
	}

	public void setChecker(Checker checker) {
		this.checker = checker;
	}

	public CheckerDefinition getCheckerDefinition() {
		return this.checkerDefinition;
	}

	public void setCheckerDefinition(CheckerDefinition checkerDefinition) {
		this.checkerDefinition = checkerDefinition;
	}

}