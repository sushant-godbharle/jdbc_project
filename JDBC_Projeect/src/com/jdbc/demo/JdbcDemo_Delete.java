package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo_Delete {

	public static void main(String[] args) {

		System.out.println("main started!!");
		Connection connection = null;
		try {
			// step-1 - Register the driver class. (Note-In latest JDK versions, this step
			// is optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 - Create connection object
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db", "root", "root");
			// step-3 - create Statement/PreparedStatement object
			Statement statement = connection.createStatement();
			// step-4 - Execute the query
			String deleteQuery = "DELETE FROM `my_first_db`.students WHERE id=3;";

			int res = statement.executeUpdate(deleteQuery);

			if (res > 0) {
				System.out.println("Delete operation success!!!");
				System.out.println(res + " rows affected!!");
			} else
				System.out.println("No rows affected!!");

		} catch (ClassNotFoundException e) {
			System.out.println("111Some error occurred during connecting to DB!!" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("222Some error occurred during connecting to DB!!" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Some error occurred!!" + e.getMessage());
		} finally {

			// step-5 - Close the connection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("main ended!!");
	}

}