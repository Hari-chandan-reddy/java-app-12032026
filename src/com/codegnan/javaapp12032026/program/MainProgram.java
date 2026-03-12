package com.codegnan.javaapp12032026.program;

import com.codegnan.javaapp12032026.dao.PassportDao;
import com.codegnan.javaapp12032026.entity.Passport;
import com.codegnan.javaapp12032026.entity.Person;

public class MainProgram {

	public static void main(String[] args) {
		Person person = new Person(105, "Virat", "", "Kohli", "Male", "1988-11-05", "Delhi", "Prem Kohli", "Saroj Kohli", "Anushka Sharma");
		Passport passport = new Passport(5, "E789123456", "Regular", "2021-11-05", "2031-11-04", "Bangalore", "Karnataka", 105);
		
		PassportDao passportdao = new PassportDao();
		int numberOfRowsAffected = passportdao.insertPersonAndPassport(person, passport);
		
		if(numberOfRowsAffected != 0) {
			System.out.println("Inserted successfully.");
		} else {
			System.out.println("Inserting person failed.");
		}
	}

}
