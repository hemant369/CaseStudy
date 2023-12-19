package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.VictimsDao;
import com.hexaware.entity.Victims;

public class VictimsController implements VictimsInterface {

	Victims victims;
	Scanner sc = new Scanner(System. in );
	VictimsDao victimsDao = new VictimsDao();

	public void addVictims() {
		victims = new Victims();

		System.out.println("Add Victim ID:");
		int victimid = sc.nextInt();
		victims.setVictimID(victimid);

		System.out.println("Add First Name:");
		String firstname = sc.next();
		victims.setFirstName(firstname);

		System.out.println("Add Last Name:");
		String lastname = sc.next();
		victims.setLastName(lastname);

		System.out.println("Add Date of Birth:");
		String incidentdate = sc.next();
		victims.setDateOfBirth(incidentdate);

		System.out.println("Add Gender:");
		String gender = sc.next();
		victims.setGender(gender);

		System.out.println("Add Contact Information:");
		String contactinformation = sc.next();
		victims.setContactInformation(contactinformation);

		victimsDao.insertVictims(victims);
	}

	public void getVictims() {
		System.out.println("Enter Victims ID");
		int victimid = sc.nextInt();

		victimsDao.getVictims(victimid);

	}
}