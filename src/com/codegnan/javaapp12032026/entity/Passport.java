package com.codegnan.javaapp12032026.entity;

import java.util.Objects;

public class Passport {
	private int passportId;
    private String passportNumber;
    private String passportType;
    private String dateOfIssue;
    private String dateOfExpiry;
    private String cityOfIssue;
    private String stateOfIssue;
    private int personId;
    
	public Passport() {
	}

	public Passport(int passportId, String passportNumber, String passportType, String dateOfIssue, String dateOfExpiry,
			String cityOfIssue, String stateOfIssue, int personId) {
		this.passportId = passportId;
		this.passportNumber = passportNumber;
		this.passportType = passportType;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
		this.cityOfIssue = cityOfIssue;
		this.stateOfIssue = stateOfIssue;
		this.personId = personId;
	}

	public int getPassportId() {
		return passportId;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public String getPassportType() {
		return passportType;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public String getCityOfIssue() {
		return cityOfIssue;
	}

	public String getStateOfIssue() {
		return stateOfIssue;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public void setPassportType(String passportType) {
		this.passportType = passportType;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public void setCityOfIssue(String cityOfIssue) {
		this.cityOfIssue = cityOfIssue;
	}

	public void setStateOfIssue(String stateOfIssue) {
		this.stateOfIssue = stateOfIssue;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", passportNumber=" + passportNumber + ", passportType="
				+ passportType + ", dateOfIssue=" + dateOfIssue + ", dateOfExpiry=" + dateOfExpiry + ", cityOfIssue="
				+ cityOfIssue + ", stateOfIssue=" + stateOfIssue + ", personId=" + personId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityOfIssue, dateOfExpiry, dateOfIssue, passportId, passportNumber, passportType, personId,
				stateOfIssue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passport other = (Passport) obj;
		return Objects.equals(cityOfIssue, other.cityOfIssue) && Objects.equals(dateOfExpiry, other.dateOfExpiry)
				&& Objects.equals(dateOfIssue, other.dateOfIssue) && passportId == other.passportId
				&& Objects.equals(passportNumber, other.passportNumber)
				&& Objects.equals(passportType, other.passportType) && personId == other.personId
				&& Objects.equals(stateOfIssue, other.stateOfIssue);
	}
}
