package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Incidents;
import com.hexaware.util.DBConnection;

import com.hexaware.exception.IncidentNumberNotFoundException;

public class IncidentsDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public boolean insertIncident(int incidentid,String incidenttype, String incidentdate,double latitude,double longitude,String description,String status,int victimid,int suspectid) {
		boolean isinsert = true;
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("insert into incidents values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, incidentid);
	        ps.setString(2, incidenttype);
	        ps.setString(3, incidentdate); 
	        ps.setDouble(4, latitude);
	        ps.setDouble(5, longitude);
	        ps.setString(6, description);
	        ps.setString(7, status);
	        ps.setInt(8, victimid);
	        ps.setInt(9, suspectid);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return isinsert;
	}

	public void showIncident(int incidentID) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT * FROM incidents WHERE incidentID=? ");
			ps.setInt(1, incidentID);
			rs = ps.executeQuery();

			if (rs.next()) {
				int incidentid = rs.getInt("IncidentID");
				String incidentType = rs.getString("IncidentType");
				String incidentDate = rs.getString("IncidentDate");
				String latitude = rs.getString("LocationLatitude");
				String longitude = rs.getString("LocationLongitude");
				String description = rs.getString("Descriptions");
				String status = rs.getString("Status");
				int victimID = rs.getInt("VictimID");
				int suspectID = rs.getInt("SuspectID");

				System.out.println("IncidentID: " + incidentid);
				System.out.println("IncidentType: " + incidentType);
				System.out.println("IncidentDate: " + incidentDate);
				System.out.println("Latitude: " + latitude);
				System.out.println("Longitude: " + longitude);
				System.out.println("Description: " + description);
				System.out.println("Status: " + status);
				System.out.println("VictimID: " + victimID);
				System.out.println("SuspectID: " + suspectID);
			} else {
				throw new IncidentNumberNotFoundException();
			}
		} catch(IncidentNumberNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (connection != null) connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean updateIncident(int incidentid, String status) {
		boolean isupdate = true;
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("update incidents set status=? where incidentID=?");
			ps.setString(1, status);
			ps.setInt(2, incidentid);
			
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return isupdate;
	}

	public void IncidentReport(int incidentid) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT i.IncidentID, i.IncidentType, i.IncidentDate,i.Descriptions, i.Status,r.ReportID, r.OfficerID, r.ReportDate, r.ReportDetails, r.Status AS ReportStatus FROM Incidents i JOIN Reports r ON i.IncidentID = r.IncidentID WHERE i.IncidentID = ?");
			ps.setInt(1, incidentid);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Incident ID: " + rs.getInt("IncidentID"));
				System.out.println("Incident Type: " + rs.getString("IncidentType"));
				System.out.println("Incident Date: " + rs.getString("IncidentDate"));
				System.out.println("Description: " + rs.getString("Descriptions"));
				System.out.println("Status: " + rs.getString("Status"));

				System.out.println("Report ID: " + rs.getInt("ReportID"));
				System.out.println("Reporting Officer ID: " + rs.getInt("OfficerID"));
				System.out.println("Report Date: " + rs.getString("ReportDate"));
				System.out.println("Report Details: " + rs.getString("ReportDetails"));
				System.out.println("Report Status: " + rs.getString("Status"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void showIncidentReport(String startdate, String enddate) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT * FROM Incidents WHERE IncidentDate BETWEEN ? AND ?");
			ps.setString(1, startdate);
			ps.setString(2, enddate);
			rs = ps.executeQuery();
			while (rs.next()) {
				int incidentID = rs.getInt("IncidentID");
				String incidentType = rs.getString("IncidentType");
				String incidentDate = rs.getString("IncidentDate");

				System.out.println("IncidentID: " + incidentID);
				System.out.println("IncidentType: " + incidentType);
				System.out.println("IncidentDate: " + incidentDate);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}