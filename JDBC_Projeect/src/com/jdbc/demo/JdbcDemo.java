package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo {

	public static void main(String[] args) {

		System.out.println("main started..");
		Connection connection = null;
		List<Student> stdList = new ArrayList<Student>();

		try {
			// step-1 Register the driver class. (Note -In latest JDK versions,this step is
			// optional

			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 create connection object
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db", "root", "root");

			// step 3 -create Statement/ PreparedStatement object
			Statement statement = connection.createStatement();
			// step-4 - Execute the query
			ResultSet rs = statement.executeQuery("Select * from students");

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				float marks = rs.getFloat(4);

				System.out.println("Fetched row from DB:" + "id = " + id + "name = " + name + "address = " + address
						+ "marks= " + marks);

				Student std = new Student(id, name, address, marks);
				stdList.add(std);

			}
		}

		catch (ClassNotFoundException e) {
			System.out.println("111 Some error occurred during connecting to database!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("222 Some error occurred during connecting to database!!");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Some error occurred!!" + e.getMessage());
		}

		finally {
			// step-5 CLose the connection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Students from database: " + stdList);

		System.out.println("main ended!!");

	}

}
