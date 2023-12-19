package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.CaseDetails;
import com.hexaware.util.DBConnection;

public class CaseDetailsDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertCaseDetails(CaseDetails casedetails) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("insert into casedetails values(?,?,?)");
			ps.setInt(1, casedetails.getCaseID());
			ps.setInt(2, casedetails.getIncidentID());
			ps.setString(3, casedetails.getDescription());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void showCaseDetails(int caseID) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT cd.caseid,i.incidentType, s.firstName AS SuspectFirstName, s.lastName AS SuspectLastName, v.firstName AS VictimFirstName, v.lastName AS VictimLastName, lea.agencyName, o.firstName AS OfficerFirstName, o.lastName AS OfficerLastName, r.status FROM CaseDetails cd JOIN Incidents i ON cd.incidentID = i.incidentID JOIN Suspects s ON i.suspectID = s.suspectID JOIN Victims v ON v.victimID = i.victimID JOIN Reports r ON i.incidentID = r.incidentID JOIN Officers o ON r.officerID = o.officerID JOIN LawEnforcementAgencies lea ON o.agencyID = lea.agencyID WHERE cd.caseID = ?;");
			ps.setInt(1, caseID);
			rs = ps.executeQuery();

			while (rs.next()) {
				int caseid = rs.getInt("caseID");
				String incidentType = rs.getString("incidentType");
				String suspectFirstName = rs.getString("SuspectFirstName");
				String suspectLastName = rs.getString("SuspectLastName");
				String victimFirstName = rs.getString("VictimFirstName");
				String victimLastName = rs.getString("VictimLastName");
				String agencyName = rs.getString("agencyName");
				String officerFirstName = rs.getString("OfficerFirstName");
				String officerLastName = rs.getString("OfficerLastName");
				String status = rs.getString("status");

				System.out.println("Case ID: " + caseid);
				System.out.println("IncidentType: " + incidentType);
				System.out.println("Suspect Name: " + suspectFirstName + " " + suspectLastName);
				System.out.println("Victim Name: " + victimFirstName + " " + victimLastName);
				System.out.println("Agency Name: " + agencyName);
				System.out.println("Officer Name: " + officerFirstName + " " + officerLastName);
				System.out.println("Status of Case: " + status);
				System.out.println("-----------------------------");
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCaseDetails(CaseDetails casedetails) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("update casedetails set description=? where caseID=?");
			ps.setInt(1, casedetails.getCaseID());
			ps.setString(2, casedetails.getDescription());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}
	public List < CaseDetails > getAllCaseDetails() {

		List < CaseDetails > casedetailslist = new ArrayList < >();
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from casedetails ");
			rs = ps.executeQuery();
			while (rs.next()) {
				CaseDetails casedetails = new CaseDetails();
				casedetails.setCaseID(rs.getInt(1));
				casedetails.setIncidentID(rs.getInt(2));
				casedetails.setDescription(rs.getString(3));

				casedetailslist.add(casedetails);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return casedetailslist;
	}

}