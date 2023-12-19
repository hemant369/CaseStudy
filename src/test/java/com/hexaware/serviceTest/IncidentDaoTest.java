package com.hexaware.serviceTest;


import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hexaware.dao.IncidentsDao;
import com.hexaware.util.DBConnection;

public class IncidentDaoTest {
    private static IncidentsDao incidentsDao;
    private static Connection connection;
    
    @BeforeClass
    public static void setUpClass() {
        incidentsDao = new IncidentsDao();
        connection = DBConnection.getMyDbConnection();
    }

    @Test
    public void updateIncidentStatusTest() {
        assertTrue(incidentsDao.updateIncident(1, "open"));
    }

    @Test
    public void insertIncidentTest() {
        assertTrue(incidentsDao.insertIncident(4, "robbery", "2023-09-09", 25.36, 29.30, "cash", "open", 2, 3));
    }

	@AfterClass
    public static void tearDownClass() {
        try {
            // Close the database connection
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        incidentsDao = null;
    }
}