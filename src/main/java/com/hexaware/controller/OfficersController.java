package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.OfficersDao;
import com.hexaware.entity.Officers;

public class OfficersController implements OfficersInterface {

	Officers officers;
	Scanner sc = new Scanner(System. in );
	OfficersDao officerDao = new OfficersDao();

	public void addOfficers() {
		officers = new Officers();

		System.out.println("Add Officers ID:");
		int officerid = sc.nextInt();
		officers.setOfficerID(officerid);

		System.out.println("Add First Name:");
		String firstname = sc.next();
		officers.setFirstName(firstname);

		System.out.println("Add Last Name:");
		String lastname = sc.next();
		officers.setLastName(lastname);

		System.out.println("Add Badge Number:");
		int badge = sc.nextInt();
		officers.setBadgeNumber(badge);

		System.out.println("Add Rank:");
		String rank = sc.next();
		officers.setRank(rank);

		System.out.println("Add Contact Information:");
		String contact = sc.next();
		officers.setContactInformation(contact);

		System.out.println("Add Agency ID:");
		int agencyid = sc.nextInt();
		officers.setAgencyID(agencyid);

		officerDao.insertOfficers(officers);
	}

	public void getOfficers() {
		System.out.println("Enter Officers ID");
		int officerid = sc.nextInt();

		officerDao.showOfficers(officerid);
	}
}