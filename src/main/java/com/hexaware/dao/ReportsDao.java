package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Reports;
import com.hexaware.util.DBConnection;

public class ReportsDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertReports(Reports reports) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("insert into reports values(?,?,?,?,?,?)");
			ps.setInt(1, reports.getReportID());
			ps.setInt(2, reports.getIncidentID());
			ps.setInt(3, reports.getOfficerID());
			ps.setString(4, reports.getReportDate());
			ps.setString(5, reports.getReportDetails());
			ps.setString(6, reports.getStatus());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void showReports(int reportID) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from reports where reportID=? ");
			ps.setInt(1, reportID);
			rs = ps.executeQuery();
			if (rs.next()) {
				int reportid = rs.getInt("ReportID");
				int incidentID = rs.getInt("IncidentID");
				int reportingOfficerID = rs.getInt("Officerid");
				String reportDate = rs.getString("ReportDate");
				String reportDetails = rs.getString("ReportDetails");
				String status = rs.getString("Status");

				System.out.println("ReportID: " + reportid);
				System.out.println("IncidentID: " + incidentID);
				System.out.println("ReportingOfficerID: " + reportingOfficerID);
				System.out.println("ReportDate: " + reportDate);
				System.out.println("ReportDetails: " + reportDetails);
				System.out.println("Status: " + status);
			} else {
				System.out.println("Report with ID " + reportID + " not found.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}