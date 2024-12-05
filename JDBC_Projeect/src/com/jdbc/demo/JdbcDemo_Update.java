package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo_Update {

    public static void main(String[] args) {

        System.out.println("main started!!");
        Connection connection = null;
        try {
            // Step 1: Register the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection object
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db", "root", "root");
            connection.setAutoCommit(true); // Enable autocommit

            // Step 3: Create Statement object
            Statement statement = connection.createStatement();

            // Step 4: Execute the query
            String updateQuery = "UPDATE students SET address = 'S B Road11 Pune' WHERE marks BETWEEN 99.98 AND 100.00;";
            System.out.println("Executing query: " + updateQuery);

            int res = statement.executeUpdate(updateQuery);

            if (res > 0) {
                System.out.println("Update operation success!!!");
                System.out.println(res + " rows affected!!");
            } else {
                System.out.println("No rows affected!!");
            }

            // Fetch and print the data after update
            var resultSet = statement.executeQuery("SELECT * FROM students;");
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id") +
                                   ", name: " + resultSet.getString("name") +
                                   ", address: " + resultSet.getString("address") +
                                   ", marks: " + resultSet.getFloat("marks"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error loading database driver!! " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error occurred!! " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("main ended!!");
    }
}
