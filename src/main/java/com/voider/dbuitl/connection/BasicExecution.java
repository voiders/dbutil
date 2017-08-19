package com.voider.dbuitl.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Edgar Xolop
 *
 */
public abstract class BasicExecution  {
	BaseConnetion baseConnection;
		
	abstract void loadBaseConnection(BaseConnetion base);
	
	private Connection getConnection(){
		return baseConnection.getConnection();
	}	

	private Boolean closeConnection(){
		return baseConnection.closeConnection();
	}
	
	public BaseConnetion getBaseConnection(){
		return baseConnection;
	};
	

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
