package com.voider.dbuitl.annotation;

public class ColumnObject {
	private String name;
	private String alias;
	private Boolean primaryKey;
	private Boolean autoAssigned;
	
	public ColumnObject(String name, String alias, Boolean primaryKey, Boolean autoAssigned) {
		super();
		this.name = name;
		this.alias = alias;
		this.primaryKey = primaryKey;
		this.autoAssigned = autoAssigned;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Boolean getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Boolean getAutoAssigned() {
		return autoAssigned;
	}
	public void setAutoAssigned(Boolean autoAssigned) {
		this.autoAssigned = autoAssigned;
	}
	
}
