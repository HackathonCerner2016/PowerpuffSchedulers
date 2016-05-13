package ro.cerner.envdashboard.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CheckerDefinition database table.
 * 
 */
@Entity
@NamedQuery(name="CheckerDefinition.findAll", query="SELECT c FROM CheckerDefinition c")
public class CheckerDefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	@Column(name="FieldLength")
	private int fieldLength;

	@Column(name="FieldName")
	private Object fieldName;

	@Column(name="FieldType")
	private Object fieldType;

	@Column(name="Position")
	private int position;

	//bi-directional many-to-one association to CheckerType
	@ManyToOne
	@JoinColumn(name="CheckerTypeId")
	private CheckerType checkerType;

	//bi-directional many-to-one association to CheckerDetails1
	@OneToMany(mappedBy="checkerDefinition")
	private List<CheckerDetails> checkerDetails;

	public CheckerDefinition() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFieldLength() {
		return this.fieldLength;
	}

	public void setFieldLength(int fieldLength) {
		this.fieldLength = fieldLength;
	}

	public Object getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(Object fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(Object fieldType) {
		this.fieldType = fieldType;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public CheckerType getCheckerType() {
		return this.checkerType;
	}

	public void setCheckerType(CheckerType checkerType) {
		this.checkerType = checkerType;
	}

	public List<CheckerDetails> getCheckerDetails() {
		return this.checkerDetails;
	}

	public void setCheckerDetails(List<CheckerDetails> checkerDetails) {
		this.checkerDetails = checkerDetails;
	}

	public CheckerDetails addCheckerDetails(CheckerDetails checkerDetails) {
		getCheckerDetails().add(checkerDetails);
		checkerDetails.setCheckerDefinition(this);

		return checkerDetails;
	}

	public CheckerDetails removeCheckerDetails(CheckerDetails checkerDetails) {
		getCheckerDetails().remove(checkerDetails);
		checkerDetails.setCheckerDefinition(null);

		return checkerDetails;
	}

}