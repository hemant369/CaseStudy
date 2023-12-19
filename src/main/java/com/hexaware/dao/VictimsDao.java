package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Victims;
import com.hexaware.util.DBConnection;

public class VictimsDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertVictims(Victims victims) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("insert into victims values(?,?,?,?,?,?)");
			ps.setInt(1, victims.getVictimID());
			ps.setString(2, victims.getFirstName());
			ps.setString(3, victims.getLastName());
			ps.setString(4, victims.getDateOfBirth());
			ps.setString(5, victims.getGender());
			ps.setString(6, victims.getContactInformation());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void getVictims(int victimID) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from victims where victimID=? ");
			ps.setInt(1, victimID);
			rs = ps.executeQuery();
			if (rs.next()) {
				int victimid = rs.getInt("VictimID");
				String firstname = rs.getString("FirstName");
				String lastname = rs.getString("LastName");
				String dateofbirth = rs.getString("DateOfBirth");
				String gender = rs.getString("Gender");
				String contact = rs.getString("ContactInformation");

				System.out.println("ReportID: " + victimid);
				System.out.println("First Name: " + firstname);
				System.out.println("Last Name: " + lastname);
				System.out.println("Date of Birth: " + dateofbirth);
				System.out.println("Gender: " + gender);
				System.out.println("Contact: " + contact);
			} else {
				System.out.println("Report with ID " + victimID + " not found.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}