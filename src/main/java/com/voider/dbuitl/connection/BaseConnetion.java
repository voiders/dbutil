package com.voider.dbuitl.connection;

import java.sql.Connection;
/**
 * 
 * @author Edgar Xolop
 *
 */

public interface BaseConnetion {

	Connection getConnection();
	Connection closeConnection();
}
