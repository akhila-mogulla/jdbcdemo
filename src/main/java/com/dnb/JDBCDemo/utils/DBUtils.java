package com.dnb.JDBCDemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public class DBUtils {
	
	private static Properties properties;
	
	private static Properties getProperties() {
		
		InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("Application.properties");
		
		if(inputStream!=null) {
			properties = new Properties();
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return properties;
		}
		
		
		System.out.println(inputStream==null);
		//return properties;
		System.out.println();
		
		return null;
		
	}
	
	public static Optional<Connection> getConnection() {
		Properties properties = getProperties();
		Connection connection;
		try {
			connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
									properties.getProperty("jdbc.username"),
									properties.getProperty("jdbc.password"));
			return Optional.of(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
		
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(DBUtils.getProperties());
	}

}
