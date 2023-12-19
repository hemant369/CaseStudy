package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.SuspectsDao;
import com.hexaware.entity.Suspects;

public class SuspectsController implements SuspectsInterface {

	Suspects suspects;
	Scanner sc = new Scanner(System. in );
	SuspectsDao suspectsDao = new SuspectsDao();

	public void addSuspects() {
		suspects = new Suspects();

		System.out.println("Add Suspects ID:");
		int victimid = sc.nextInt();
		suspects.setSuspectID(victimid);

		System.out.println("Add First Name:");
		String firstname = sc.next();
		suspects.setFirstName(firstname);

		System.out.println("Add Last Name:");
		String lastname = sc.next();
		suspects.setLastName(lastname);

		System.out.println("Add Date of Birth:");
		String incidentdate = sc.next();
		suspects.setDateOfBirth(incidentdate);

		System.out.println("Add Gender:");
		String gender = sc.next();
		suspects.setGender(gender);

		System.out.println("Add Contact Information:");
		String contactinformation = sc.next();
		suspects.setContactInformation(contactinformation);

		suspectsDao.insertSuspects(suspects);
	}

	public void getSuspects() {
		System.out.println("Enter Suspects ID");
		int suspectid = sc.nextInt();

		suspectsDao.showSuspects(suspectid);
	}
}