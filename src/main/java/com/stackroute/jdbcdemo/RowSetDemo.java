package com.stackroute.jdbcdemo;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo {

    public  void getAllCourse() {
        Connection connection=null;
        Statement statement=null;
        try {

            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creating and Executing RowSet

            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/student","root","Root@123");
            // Creating statement
            statement=connection.createStatement();
            // Executing query
            ResultSet resultSet=statement.executeQuery("select * from course");

            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(resultSet);
            while (rowSet.next()) {
                int id = rowSet.getInt(1);
                System.out.print("CourseId: "+id);
                String name=rowSet.getString(2);
                System.out.print("CourseName: "+name);
                int duration=rowSet.getInt(3);
                System.out.print("CourseDuration: "+duration);
            }
        }
        catch(ClassNotFoundException classNotFound)
        {
            System.out.println("Exception thrown1:"+classNotFound.getStackTrace());
        }
        catch (SQLException sqlException)
        {
            System.out.println("Exception thrown2:"+sqlException.getStackTrace());
        }
        finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }
            catch (Exception exception) {
            }
        }
    }
    public  void getCourseByName(String coursename) {
        Connection connection=null;
        Statement statement=null;
        try {

            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creating and Executing RowSet

            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/student","root","Root@123");
            // Creating statement
            statement=connection.createStatement();
            // Executing query
            ResultSet resultSet=statement.executeQuery("select * from course where name='Core Java'");

            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(resultSet);
            while (rowSet.next()) {
                int id = rowSet.getInt(1);
                System.out.print("CourseId: "+id);
                String name=rowSet.getString(2);
                System.out.print("CourseName: "+name);
                int duration=rowSet.getInt(3);
                System.out.print("CourseDuration: "+duration);
            }
        }
        catch(ClassNotFoundException classNotFound)
        {
            System.out.println("Exception thrown1:"+classNotFound.getStackTrace());
        }
        catch (SQLException sqlException)
        {
            System.out.println("Exception thrown2:"+sqlException.getStackTrace());
        }
        finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }
            catch (Exception exception) {
            }
        }
    }

    //third method
    public  void getCourseByNameAndDuration(String coursename,int durations) {
        Connection connection=null;
        Statement statement=null;
        try {

            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creating and Executing RowSet

            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/student","root","Root@123");
            // Creating statement
            statement=connection.createStatement();
            // Executing query
            ResultSet resultSet=statement.executeQuery("select * from course where name='bootstrap' and duration=2");

            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(resultSet);
            while (rowSet.next()) {
                int id = rowSet.getInt(1);
                System.out.print("CourseId: "+id);
                String name=rowSet.getString(2);
                System.out.print("CourseName: "+name);
                int duration=rowSet.getInt(3);
                System.out.print("CourseDuration: "+duration);
            }
        }
        catch(ClassNotFoundException classNotFoundException)
        {
            System.out.println("Exception thrown1:"+classNotFoundException.getStackTrace());
        }
        catch (SQLException sqlException)
        {
            System.out.println("Exception thrown2:"+sqlException.getStackTrace());
        }
        finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }
            catch (Exception exception) {
            }
        }
    }

}
