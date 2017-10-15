package com.voider.dbutil.connection;

import java.sql.Connection;
/**
 * BaseConnetion.java
 * 
 * Interface class that define minimum methods for custom connection class
 * 
 * @author Edgar Xolop
 *
 */

public interface BaseConnetion {
	/**
	 * Configuration necessary to connect  with the database
	 */
	void init();
	/**
	 * 
	 * @return return database connection
	 */
	Connection getConnection();
	/**
	 * close the currente connection
	 * @return
	 */
	Boolean closeConnection();
}
