package com.stackroute.jdbcdemo;

import java.sql.*;

public class PreparedStatementDemo {
    public void getCourseByName(String courseName) throws SQLException,ClassNotFoundException {
        try (Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");PreparedStatement preparedStatement=connection.prepareStatement("select * from course where name =?"))
             {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            //String query="select * from course where name =?";
            //PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,courseName);
            ResultSet resultSet = preparedStatement.executeQuery();
            //resultSet.absolute(4);
//            resultSet.afterLast();
//            while (resultSet.previous()) {
//                int id = resultSet.getInt(1);
//                System.out.println(id);
//                String s=resultSet.getString(2);
//                System.out.println(s);
//            }
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println(id);
                String name=resultSet.getString(2);
                System.out.println(name);
                int duration=resultSet.getInt(3);
                System.out.println(duration);

            }
        } catch (ClassNotFoundException e) {
            System.out.println("exception thrown" + e.getStackTrace());
        } catch (SQLException sqlException) {
            System.out.println("exception thrown" + sqlException.getStackTrace());
        }
    }
}
