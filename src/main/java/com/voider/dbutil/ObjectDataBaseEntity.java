package com.voider.dbutil;

import com.voider.dbutil.connection.VoiderConnection;

public class ObjectDataBaseEntity {
	
	private VoiderConnection voiderConnection;
	private SQLBuilder sqlBuilder;
	
	public ObjectDataBaseEntity(VoiderConnection voiderConnection){
		
		this.voiderConnection = voiderConnection;
		this.sqlBuilder = new SQLBuilder();
	}
	
	
	public VoiderConnection getVoiderConnection(){
		return this.voiderConnection;
	}
}
