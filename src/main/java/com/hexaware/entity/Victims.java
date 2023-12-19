package com.hexaware.entity;
public class Victims {

	private int victimID;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String contactinformation;

	public int getVictimID() {
		return victimID;
	}

	public void setVictimID(int victimID) {
		this.victimID = victimID;
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