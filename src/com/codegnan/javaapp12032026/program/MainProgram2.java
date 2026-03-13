package com.codegnan.javaapp12032026.program;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.codegnan.javaapp12032026.dao.PassportDao;
import com.codegnan.javaapp12032026.entity.Passport;
import com.codegnan.javaapp12032026.entity.Person;

public class MainProgram2 {

	public static void main(String[] args) {
		PassportDao passportdao = new PassportDao();
		//HashMap<Person, Passport> hashMap = passportdao.selectAllFromPersonAndPassport();
		LinkedHashMap<Person, Passport> hashMap = passportdao.selectAllFromPersonAndPassport();
		
		Set<Entry<Person, Passport>> set = hashMap.entrySet();
		for (Entry<Person, Passport> entry : set) {
			Person person = entry.getKey();
			Passport passport = entry.getValue();
			
			System.out.println(person);
			System.out.println(passport);
			System.out.println();
		}
	}

}
