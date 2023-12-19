package com.hexaware.controller;

import com.hexaware.dao.CaseDetailsDao;
import com.hexaware.entity.CaseDetails;
import java.util.List;
import java.util.Scanner;

public class CaseDetailsController implements CaseDetailsInterface {
	CaseDetails casedetails;
	Scanner sc = new Scanner(System.in);
	CaseDetailsDao casedetailsDao = new CaseDetailsDao();

	public void addCaseDetails() {
		casedetails = new CaseDetails();

		System.out.println("Add Case ID:");
		int caseid = sc.nextInt();
		casedetails.setCaseID(caseid);

		System.out.println("Add Incident ID:");
		int incidentid = sc.nextInt();
		casedetails.setIncidentID(incidentid);

		sc.nextLine();
		System.out.println("Add Description:");
		String description = sc.nextLine();
		casedetails.setDescription(description);

		casedetailsDao.insertCaseDetails(casedetails);
	}

	public void getCaseDetails() {
		System.out.println("Enter Case ID:");
		int caseid = sc.nextInt();

		casedetailsDao.showCaseDetails(caseid);
	}

	public void updateCaseDetails() {
		casedetails = new CaseDetails();

		System.out.println("Enter Case ID:");
		int incidentid = sc.nextInt();
		casedetails.setIncidentID(incidentid);

		System.out.println("Update Status:");
		String status = sc.next();
		casedetails.setDescription(status);

		casedetailsDao.updateCaseDetails(casedetails);
	}

	public void getAllCaseDetails() {
		List<CaseDetails> casedetailslist = casedetailsDao.getAllCaseDetails();
		System.out.println(casedetailslist);
	}
}