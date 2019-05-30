package com.stackroute.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBatchProcessingDemo {

    public void getJDBCBatchProcessing()
    {
        Connection connection = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            statement.addBatch("insert into course values(5, 'javascript', 3)");
            statement.addBatch("insert into course values(6, 'bootstrap', 2)");
            statement.addBatch("insert into course values(7, 'J2EE', 4)");
            statement.executeBatch();
            connection.commit();
        }

        catch(ClassNotFoundException classNotFoundException)
        {
            System.out.println("exception thrown: "+classNotFoundException.getStackTrace());
        }
        catch(SQLException sqlException)
        {
            System.out.println("exception thrown: "+sqlException.getStackTrace());
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
