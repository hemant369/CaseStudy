package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.ReportsDao;
import com.hexaware.entity.Reports;

public class ReportsController implements ReportsInterface {

	Reports reports;
	Scanner sc = new Scanner(System. in );
	ReportsDao reportsDao = new ReportsDao();

	public void addReports() {

		reports = new Reports();

		System.out.println("Add Report ID:");
		int reportid = sc.nextInt();
		reports.setReportID(reportid);

		System.out.println("Add Incident ID:");
		int incidentid = sc.nextInt();
		reports.setIncidentID(incidentid);

		System.out.println("Add Reporting Officer ID:");
		int officerid = sc.nextInt();
		reports.setOfficerID(officerid);

		System.out.println("Add Incident Date:");
		String reportdate = sc.next();
		reports.setReportDate(reportdate);

		sc.nextLine();
		System.out.println("Add Report Details:");
		String details = sc.nextLine();
		reports.setReportDetails(details);

		System.out.println("Add Status:");
		String status = sc.next();
		reports.setStatus(status);

		reportsDao.insertReports(reports);
	}

	public void getReports() {
		System.out.println("Enter Report ID");
		int reportid = sc.nextInt();

		reportsDao.showReports(reportid);
	}
}