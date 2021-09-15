package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Driver driver = new Driver();
			// Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/learndb",
					"root",
					"password");
			System.out.println(connection.getClass().getName());
			System.out.println("Connection successful.");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into department (name) values ('Innovation')");
			
			// SQL Injection Demo Code
			/*String departmentName = "Statistics";
			String sql = "insert into department (name) values ('" + departmentName + "')";
			statement.executeUpdate(sql);
			
			departmentName = "Research";
			sql = "insert into department (name) values ('" + departmentName + "')";
			statement.executeUpdate(sql);
			
			String password = "123@gmail.com' or 1 = 1";
			sql = "select * from user where email = '" + email + "' and password = '" + password "'";
			
			
			sql = "select * from user where email = 'x@gmail.com' and password = '123@gmail.com' or 1 = 1";*/
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
