package ca.sheridancollege.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;

public class DataAccess {
	
	private String connURL = "jdbc:mysql://localhost/bouncer";
	private String username = "root";
	private String password = "root";
	
	Connection conn = null;
	PreparedStatement ps = null;
	
	public DataAccess() {
		// first load the driver - it all needs to be done here because there isn't a main method
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void connect() {
		
		try {
			conn = DriverManager.getConnection(connURL,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertRow(String ipAddress) {
		Calendar c = Calendar.getInstance();
		Date d = new Date(c.getTimeInMillis());
		Time t = new Time(c.getTimeInMillis());
		String sqlCommand = "INSERT INTO LOG (IP, DATE, TIME) "+
				"VALUES (?,?,?)";
		try {
			ps = conn.prepareStatement(sqlCommand);
			ps.setString(1, ipAddress);
			ps.setDate(2, d);
			ps.setTime(3, t);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
