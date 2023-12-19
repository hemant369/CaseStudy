package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Officers;
import com.hexaware.util.DBConnection;

public class OfficersDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertOfficers(Officers officers) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("insert into officers values(?,?,?,?,?,?,?)");
			ps.setInt(1, officers.getOfficerID());
			ps.setString(2, officers.getFirstName());
			ps.setString(3, officers.getLastName());
			ps.setDouble(4, officers.getBadgeNumber());
			ps.setString(5, officers.getRank());
			ps.setString(6, officers.getContactInformation());
			ps.setInt(7, officers.getAgencyID());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void showOfficers(int officerID) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from officers where officerID=? ");
			ps.setInt(1, officerID);
			rs = ps.executeQuery();
			if (rs.next()) {
				int officerid = rs.getInt("OfficerID");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String badgeNumber = rs.getString("BadgeNumber");
				String rank = rs.getString("Ranks");
				String contactInformation = rs.getString("ContactInformation");
				int agencyID = rs.getInt("AgencyID");

				System.out.println("OfficerID: " + officerid);
				System.out.println("FirstName: " + firstName);
				System.out.println("LastName: " + lastName);
				System.out.println("BadgeNumber: " + badgeNumber);
				System.out.println("Rank: " + rank);
				System.out.println("ContactInformation: " + contactInformation);
				System.out.println("AgencyID: " + agencyID);
				System.out.println("------------");
			}
			else {
				System.out.println("Officer with ID " + officerID + " not found.");
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}