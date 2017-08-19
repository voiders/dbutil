package com.voider.dbuitl.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * 
 * @author Edgar Xolop
 *
 */
public class DataSourceConnection implements BaseConnetion{
    
	private Connection conn ;
	private DataSource ds;
	private String nameContext;
	
	public DataSourceConnection(String nameContext) {
		this.nameContext = nameContext;
	}
	
	@Override
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
