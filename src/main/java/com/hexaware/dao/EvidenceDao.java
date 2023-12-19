package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Evidence;
import com.hexaware.util.DBConnection;

public class EvidenceDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertEvidence(Evidence evidence) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("insert into evidence values(?,?,?,?)");
			ps.setInt(1, evidence.getEvidenceID());
			ps.setString(2, evidence.getDescription());
			ps.setString(3, evidence.getLocationFound());
			ps.setDouble(4, evidence.getIncidentID());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertEvidence(int evidenceID) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from evidence where evidenceID=? ");
			ps.setInt(1, evidenceID);
			rs = ps.executeQuery();
			while (rs.next()) {
				int evidenceid = rs.getInt("EvidenceID");
				String description = rs.getString("Descriptions");
				String locationFound = rs.getString("LocationFound");
				int incidentID = rs.getInt("IncidentID");

				System.out.println("EvidenceID: " + evidenceid);
				System.out.println("Description: " + description);
				System.out.println("Location Found: " + locationFound);
				System.out.println("IncidentID: " + incidentID);
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}