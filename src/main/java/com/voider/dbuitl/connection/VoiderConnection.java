package com.voider.dbuitl.connection;
/**
 * 
 * @author Edgar Xolop
 *
 */
public class VoiderConnection extends BasicExecution {

	private static VoiderConnection instance;
	
	public static VoiderConnection getInstance(){
		
		if(instance == null){
			instance = new VoiderConnection();
		}
		
		return instance;
	}

	@Override
	void loadBaseConnection(BaseConnetion base) {
		baseConnection = base;
	}
}
