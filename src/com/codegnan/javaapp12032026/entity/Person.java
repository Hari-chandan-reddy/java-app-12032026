package com.codegnan.javaapp12032026.entity;

import java.util.Objects;

public class Person {
	private int personId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String cityOfBirth;
    private String fatherName;
    private String motherName;
    private String husbandSpouseName;
        
	public Person() {
	}

	public Person(int personId, String firstName, String middleName, String lastName, String gender, String dateOfBirth,
			String cityOfBirth, String fatherName, String motherName, String husbandSpouseName) {
		this.personId = personId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.cityOfBirth = cityOfBirth;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.husbandSpouseName = husbandSpouseName;
	}

	public int getPersonId() {
		return personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getCityOfBirth() {
		return cityOfBirth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public String getHusbandSpouseName() {
		return husbandSpouseName;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public void setHusbandSpouseName(String husbandSpouseName) {
		this.husbandSpouseName = husbandSpouseName;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", cityOfBirth="
				+ cityOfBirth + ", fatherName=" + fatherName + ", motherName=" + motherName + ", husbandSpouseName="
				+ husbandSpouseName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityOfBirth, dateOfBirth, fatherName, firstName, gender, husbandSpouseName, lastName,
				middleName, motherName, personId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(cityOfBirth, other.cityOfBirth) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(fatherName, other.fatherName) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(husbandSpouseName, other.husbandSpouseName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(motherName, other.motherName) && personId == other.personId;
	}
}
