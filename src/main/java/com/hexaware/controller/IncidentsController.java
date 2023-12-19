package com.hexaware.controller;

import com.hexaware.dao.IncidentsDao;
import com.hexaware.entity.Incidents;
import java.util.Scanner;

public class IncidentsController implements IncidentsInterface {
	Incidents incidents;
	Scanner sc = new Scanner(System.in);
	IncidentsDao incidentsDao = new IncidentsDao();

	public void addIncident() {
		System.out.println("Add Incident ID:");
		int incidentid = sc.nextInt();

		System.out.println("Add Incident Type:");
		String incidenttype = sc.next();

		System.out.println("Add Incident Date:");
		String incidentdate = sc.next();

		System.out.println("Add Latitude:");
		double latitude = sc.nextDouble();

		System.out.println("Add Longitude:");
		double longitude = sc.nextDouble();

		sc.nextLine();
		System.out.println("Add Description:");
		String description = sc.nextLine();

		System.out.println("Add Status:");
		String status = sc.next();

		System.out.println("Add Victim ID if it is exist in victim table:");
		int victimid = sc.nextInt();

		System.out.println("Add Suspect ID if it is exist in victim table:");
		int suspectid = sc.nextInt();

		incidentsDao.insertIncident(incidentid, incidenttype, incidentdate, latitude, longitude, description, status, victimid, suspectid);
	}

	public void getIncident() {
		System.out.println("Enter Incident ID");
		int incidentid = sc.nextInt();

		incidentsDao.showIncident(incidentid);
	}

	public void updateIncidentStatus() {
		incidents = new Incidents();

		System.out.println("Enter Incident ID:");
		int incidentid = sc.nextInt();

		System.out.println("Update Status:");
		String status = sc.next();

		incidentsDao.updateIncident(incidentid, status);
	}

	public void generateIncidentReport() {
		incidents = new Incidents();

		System.out.println("Enter Incident ID:");
		int incidentid = sc.nextInt();
		incidents.setIncidentID(incidentid);

		incidentsDao.IncidentReport(incidentid);
	}

	public void getIncidentsInDate() {
		incidents = new Incidents();

		System.out.println("Enter Start Date:");
		String startdate = sc.next();

		System.out.println("Enter End Date:");
		String enddate = sc.next();

		incidentsDao.showIncidentReport(startdate, enddate);
	}
}
