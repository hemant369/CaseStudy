package com.hexaware.entity;

public class CaseDetails {

	private int caseID;
	private int incidentID;
	private String description;

	public int getCaseID() {
		return caseID;
	}

	public int getIncidentID() {
		return incidentID;
	}

	public String getDescription() {
		return description;
	}

	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}

	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "CaseDetails{" + "caseID=" + caseID + ", incidentID=" + incidentID + ", description=" + description
				+ '\'' + '}';
	}

}