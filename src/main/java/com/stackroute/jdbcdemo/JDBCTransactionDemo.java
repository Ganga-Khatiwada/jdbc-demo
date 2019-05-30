package com.stackroute.jdbcdemo;

import java.sql.*;

public class JDBCTransactionDemo {

    public void getJDBCTransaction() {
        Connection connection = null;
        Statement statement = null;
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.executeUpdate("insert into course values(8, 'bootstrap', 2)");
            statement.executeUpdate("insert into course values(9, 'Python', 5)");
            connection.commit();

        } catch (SQLException sqlException) {
            System.out.println("exception thrown: " + sqlException.getStackTrace());
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (Exception exception) {
            }
        }
    }
}