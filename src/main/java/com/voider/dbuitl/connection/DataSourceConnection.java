package com.voider.dbuitl.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * Implements BaseConnetion interface for default connection 
 * @author Edgar Xolop
 *
 */
public class DataSourceConnection implements BaseConnetion{
    
	private Connection conn ;
	private DataSource ds;
	private String nameContext;
	
	/**
	 *  
	 * @param nameContext Datasource declared
	 */
	public DataSourceConnection(String nameContext) {
		this.nameContext = nameContext;
	}
	
	@Override
	/**
	 * Load datasource properties
	 * 
	 */
	public void init(){
		Context initContext;
		
		try {
			initContext = new InitialContext();
		    Context envContext = (Context) initContext.lookup("java:comp/env");
		    ds = (DataSource) envContext.lookup(this.nameContext);
		
		    this.conn = ds.getConnection();
		    
		}  catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}

	@Override
	/**
	 * if the connection is closed,a new connection is returned
	 * @return the connection
	 */
	public Connection getConnection() {
		try {
			if(this.conn.isClosed()){
				this.conn = ds.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	/**
	 * @return true - if the connection has been closed
	 */
	public Boolean closeConnection(){
		Boolean closed = false;
		try {	
			if(!this.conn.isClosed()){
				this.conn.close();
			}			
			closed = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return closed;
	}

}
