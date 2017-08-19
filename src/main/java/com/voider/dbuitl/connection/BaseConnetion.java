package com.voider.dbuitl.connection;

import java.sql.Connection;
/**
 * 
 * @author Edgar Xolop
 *
 */

public interface BaseConnetion {

	void init();
	Connection getConnection();
	Boolean closeConnection();
}
