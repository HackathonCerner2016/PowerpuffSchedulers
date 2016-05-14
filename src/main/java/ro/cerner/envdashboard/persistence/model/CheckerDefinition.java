package ro.cerner.envdashboard.persistence.model;


public class CheckerDefinition {

	private long id;
	private int fieldLength;
	private String fieldName;
	private String fieldType;
	private int position;
	private long checkerTypeId;

	public CheckerDefinition() {
	}

	public CheckerDefinition(int fieldLength, String fieldName,
			String fieldType, int position, long checkerTypeId) {
		super();
		this.fieldLength = fieldLength;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.position = position;
		this.checkerTypeId = checkerTypeId;
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

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public long getCheckerTypeId() {
		return this.checkerTypeId;
	}

	public void setCheckerTypeId(long checkerTypeId) {
		this.checkerTypeId = checkerTypeId;
	}

}