package com.voider.dbutil;

import com.voider.dbutil.connection.BasicExecution;
public class ObjectDataBaseEntity {
	
	private BasicExecution basicExecution;
//	private SQLBuilder sqlBuilder;
	
	public ObjectDataBaseEntity(BasicExecution basicExecution){
		
		this.basicExecution = basicExecution;
//		this.sqlBuilder = new SQLBuilder();
	}
	
	public BasicExecution getVoiderConnection(){
		return this.basicExecution;
	}
}
