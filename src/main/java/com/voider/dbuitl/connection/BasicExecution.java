package com.voider.dbuitl.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Basic methods to functional connection class
 * @author Edgar Xolop
 *
 */
public abstract class BasicExecution  {
	BaseConnetion baseConnection;
	
	/**
	 * 
	 * @param base
	 */
	abstract void loadBaseConnection(BaseConnetion base);
	/**
	 * 
	 * @return return database connection
	 */
	private Connection getConnection(){
		return baseConnection.getConnection();
	}	

	/**
	 * close the currente connection
	 * @return
	 */
	private Boolean closeConnection(){
		return baseConnection.closeConnection();
	}
	/**
	 * 
	 * @return BaseConnetionn setted
	 */
	public BaseConnetion getBaseConnection(){
		return baseConnection;
	};
	
	/**
	 * Execute the query update
	 * 
	 * @param sql - update to execute "UPDATE USER SET NAME = ? , LAST_NAME = ?"
	 * @param args - parameters to load in the query "Foo","Bar"
	 * @return number of rows affected
	 * @throws SQLException
	 */
	public Integer update(String sql, Object... args) throws SQLException{
		Integer rowsAffected = 0;	
		
		getConnection();

		PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
		
		for (int i = 0; i < args.length; i++) {
			preparedStatement.setObject(i+1, args[i]);
			
		}
		rowsAffected = preparedStatement.executeUpdate();
		System.out.println("Rows affected :" + rowsAffected);
		
		closeConnection();
		
		return rowsAffected;
	}
	
	/**
	 * Execute the insert query
	 * 
	 * @param sql - update to execute "INSERT INTO USER(NAME,LAST_NAME)"
	 * @param args - parameters to load in the query "Foo","Bar"
	 * @return return the id generated 
	 * @throws SQLException
	 */
	public Integer insert(String sql, Object... args) throws SQLException{
		Integer id = null;
		
		PreparedStatement preparedStatement = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		for (int i = 0; i < args.length; i++) {
			preparedStatement.setObject(i+1, args[i]);
			
		}

		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();
		
		System.out.println("Executing sql " + preparedStatement);
		
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		
		while(resultSet.next()){
			id = resultSet.getInt(1);
		}
		
		return id;
	}	
}
