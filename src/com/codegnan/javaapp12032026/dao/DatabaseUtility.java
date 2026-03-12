package com.codegnan.javaapp12032026.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	public static void loadDriverClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}
	}
	
	public static Connection createConnection() {
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		
		Connection dbConn = null;
		
		try {
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdg_hyd_jfs_050", username, password);
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		return dbConn;
	}
	
	public static Statement createStatement(Connection connection) {
		Statement statement = null;
	
		try {
			statement = connection.createStatement();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		return statement;
	}
	
	public static ResultSet createResultSet(Statement statement, String sql) {
		ResultSet resultSet = null;
	
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		return resultSet;
	}
	
	public static int executeDml(Statement statement, String sql) {
		int numberOfRowsAffected = 0;
		
		try {
			numberOfRowsAffected = statement.executeUpdate(sql);
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		return numberOfRowsAffected;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement statement) {
		try {
			if(statement != null) {
				statement.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}
}
