package ro.cerner.envdashboard.persistence.mapper;

public class CheckerPropertiesRecord {

	private Integer id;
	private Integer checkerDefinitionId;
	private String fieldName;
	private String fieldValue;
	private Integer position;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCheckerDefinitionId() {
		return checkerDefinitionId;
	}
	public void setCheckerDefinitionId(Integer checkerDefinitionId) {
		this.checkerDefinitionId = checkerDefinitionId;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	
}
