package com.voider.dbutil.connection;
/**
 * Extends BasicExecution abstract class for default connection 
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
	/**
	 * Load the BaseConnection implemented
	 * 
	 * @param base 
	 */
	void loadBaseConnection(BaseConnetion base) {
		baseConnection = base;
	}
}
