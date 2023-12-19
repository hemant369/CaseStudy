package com.hexaware.util;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class PropertyUtil {
	public static String getPropertyString() {
		Properties properties = new Properties();
		FileInputStream fis = null;
		String fileName = "src/com/hexaware/util/db.properties";

		String url = null;
		String username = null;
		String password = null;

		try {
			fis = new FileInputStream(fileName);
			properties.load(fis);
			url = properties.getProperty("db.url");
			username = properties.getProperty("db.username");
			password = properties.getProperty("db.password");
		} catch(IOException e) {
			e.printStackTrace();
		}
		return url + " " + username + " " + password;
	}

}