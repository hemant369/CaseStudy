package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.util.DBConnection;

public class LawEnforcementAgenciesDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertLawEnforcementAgencies(LawEnforcementAgencies lawenforcementagencies) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("insert into lawenforcementagencies values(?,?,?,?,?)");
			ps.setInt(1, lawenforcementagencies.getAgencyID());
			ps.setString(2, lawenforcementagencies.getAgencyName());
			ps.setString(3, lawenforcementagencies.getJurisdiction());
			ps.setString(4, lawenforcementagencies.getContactInformation());
			ps.setString(5, lawenforcementagencies.getOfficers());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void showlawenforcementagenciesDao(int agencyid) {
		try {
			connection = DBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from lawenforcementagencies where agencyID=? ");
			ps.setInt(1, agencyid);
			rs = ps.executeQuery();
			while (rs.next()) {
				int agencyID = rs.getInt("AgencyID");
				String agencyName = rs.getString("AgencyName");
				String jurisdiction = rs.getString("Jurisdiction");
				String contactInfo = rs.getString("ContactInformation");
				String officers = rs.getString("Officers");

				System.out.println("AgencyID: " + agencyID);
				System.out.println("AgencyName: " + agencyName);
				System.out.println("Jurisdiction: " + jurisdiction);
				System.out.println("ContactInformation: " + contactInfo);
				System.out.println("Officers: " + officers);
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}