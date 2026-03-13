package com.codegnan.javaapp12032026.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
	
	// RETRIEVE ALL FROM BOTH PERSON AND PASSPORT TABLE
	//public HashMap<Person, Passport> selectAllFromPersonAndPassport() {
	public LinkedHashMap<Person, Passport> selectAllFromPersonAndPassport() {
		DatabaseUtility.loadDriverClass();
		Connection dbConn = DatabaseUtility.createConnection();
		Statement dbStmt = DatabaseUtility.createStatement(dbConn);
		
		//HashMap<Person, Passport> personPassportMap = new HashMap<Person, Passport>();
		LinkedHashMap<Person, Passport> personPassportMap = new LinkedHashMap<Person, Passport>();
		
		String sql = "SELECT per.person_id, per.first_name, per.middle_name, per.last_name, per.gender,";
			sql += " per.date_of_birth, per.city_of_birth, per.state_of_birth, per.father_name, per.mother_name, per.husband_spouse_name,";
			sql += " pas.passport_id, pas.passport_number, pas.passport_type, pas.date_of_issue, pas.date_of_expiry,";
			sql += " pas.city_of_issue, pas.state_of_issue";
			sql += " FROM person per";
			sql += " INNER JOIN passport pas";
			sql += " ON per.person_id = pas.person_id";
			
		ResultSet resultSet = DatabaseUtility.createResultSet(dbStmt, sql);
		try {
			while(resultSet.next()) {
				Person person = new Person();
				
				person.setPersonId(resultSet.getInt(1));
				person.setFirstName(resultSet.getString(2));
				person.setMiddleName(resultSet.getString(3));
				person.setLastName(resultSet.getString(4));
				person.setGender(resultSet.getString(5));
				person.setDateOfBirth(resultSet.getString(6));
				person.setCityOfBirth(resultSet.getString(7));
				person.setStateOfBirth(resultSet.getString(8));
				person.setFatherName(resultSet.getString(9));
				person.setMotherName(resultSet.getString(10));
				person.setHusbandSpouseName(resultSet.getString(11));

				Passport passport = new Passport();
				
				passport.setPassportId(resultSet.getInt(12));
				passport.setPassportNumber(resultSet.getString(13));
				passport.setPassportType(resultSet.getString(14));
				passport.setDateOfIssue(resultSet.getString(15));
				passport.setDateOfExpiry(resultSet.getString(16));
				passport.setCityOfIssue(resultSet.getString(17));
				passport.setStateOfIssue(resultSet.getString(18));
				
				personPassportMap.put(person, passport);
				
			}
		} catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		return personPassportMap;
	}
	
}