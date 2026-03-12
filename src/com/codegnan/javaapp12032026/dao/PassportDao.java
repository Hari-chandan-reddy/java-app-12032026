package com.codegnan.javaapp12032026.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.codegnan.javaapp12032026.entity.Passport;
import com.codegnan.javaapp12032026.entity.Person;

public class PassportDao {
	
	// INSERT A USER INTO DATABASE
	public int insertPersonAndPassport(Person person, Passport passport) {
		DatabaseUtility.loadDriverClass();
		Connection dbConn = DatabaseUtility.createConnection();
		Statement dbStmt = DatabaseUtility.createStatement(dbConn);
		
		String sql = "INSERT INTO person VALUES (";
		sql += person.getPersonId();
		sql += ", '" + person.getFirstName() + "'";
		sql += ", '" + person.getMiddleName() + "'";
		sql += ", '" + person.getLastName() + "'";
		sql += ", '" + person.getGender() + "'";
		sql += ", '" + person.getDateOfBirth() + "'";
		sql += ", '" + person.getCityOfBirth() + "'";
		sql += ", '" + person.getFatherName() + "'";
		sql += ", '" + person.getMotherName() + "'";
		sql += ", '" + person.getHusbandSpouseName() + "')";
		
		int numberOfRowsAffected = DatabaseUtility.executeDml(dbStmt, sql);
			
		if(numberOfRowsAffected != 0) {
			sql = "INSERT INTO passport VALUES (";
			sql += passport.getPassportId();
			sql += ", '" + passport.getPassportNumber() + "'";
			sql += ", '" + passport.getPassportType() + "'";
			sql += ", '" + passport.getDateOfIssue() + "'";
			sql += ", '" + passport.getDateOfExpiry() + "'";
			sql += ", '" + passport.getCityOfIssue() + "'";
			sql += ", '" + passport.getStateOfIssue() + "'";
			sql += ", " + passport.getPersonId() + ")";
			
			numberOfRowsAffected = DatabaseUtility.executeDml(dbStmt, sql);
		}
		
		DatabaseUtility.closeStatement(dbStmt);
		DatabaseUtility.closeConnection(dbConn);
		
		return numberOfRowsAffected;
	}
	
	/*
	// DELETE A USER BASED ON USER ID
	public boolean deleteUserById(int personId) {
		boolean isDeleted = false;
		
		DatabaseUtility.loadDriverClass();
		Connection dbConn = DatabaseUtility.createConnection();
		Statement dbStmt = DatabaseUtility.createStatement(dbConn);
		
		String sql = "DELETE FROM user_information WHERE user_id=" + personId;
		
		int rowsAffected = dbStmt.executeUpdate(sql);
			
		if(rowsAffected > 0) {
			isDeleted = true;
		}
		
		DatabaseUtility.closeStatement(dbStmt);
		DatabaseUtility.closeConnection(dbConn);
		
		return isDeleted;
	}
	*/
}