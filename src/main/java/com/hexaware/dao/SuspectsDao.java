package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Suspects;
import com.hexaware.util.DBConnection;

public class SuspectsDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertSuspects(Suspects suspects) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("insert into suspects values(?,?,?,?,?,?)");
			ps.setInt(1, suspects.getSuspectID());
			ps.setString(2, suspects.getFirstName());
			ps.setString(3, suspects.getLastName());
			ps.setString(4, suspects.getDateOfBirth());
			ps.setString(5, suspects.getGender());
			ps.setString(6, suspects.getContactInformation());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void showSuspects(int suspectID) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from suspects where suspectID=? ");
			ps.setInt(1, suspectID);
			rs = ps.executeQuery();
			if (rs.next()) {
				int suspectid = rs.getInt("SuspectID");
				String firstname = rs.getString("FirstName");
				String lastname = rs.getString("LastName");
				String dateofbirth = rs.getString("DateOfBirth");
				String gender = rs.getString("Gender");
				String contact = rs.getString("ContactInformation");

				System.out.println("ReportID: " + suspectid);
				System.out.println("First Name: " + firstname);
				System.out.println("Last Name: " + lastname);
				System.out.println("Date of Birth: " + dateofbirth);
				System.out.println("Gender: " + gender);
				System.out.println("Contact: " + contact);
			} else {
				System.out.println("Report with ID " + suspectID + " not found.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}