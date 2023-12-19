package com.hexaware.entity;

public class Suspects {

	private int suspectID;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String contactinformation;

	public int getSuspectID() {
		return suspectID;
	}

	public void setSuspectID(int suspectID) {
		this.suspectID = suspectID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactInformation() {
		return contactinformation;
	}

	public void setContactInformation(String contactinformation) {
		this.contactinformation = contactinformation;
	}

}