package com.stackroute.jdbcdemo;

import java.sql.*;

public class DataManager {
    public void getAllCourse() throws SQLException,ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from course");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println(id);
                String s=resultSet.getString(2);
                System.out.println(s);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("exception thrown" + e.getStackTrace());
        } catch (SQLException sqlException) {
            System.out.println("exception thrown" + sqlException.getStackTrace());
        }
        finally {
            try
            {
                connection.close();
            }
            catch (Exception exception) {
            }
        }
    }
}
