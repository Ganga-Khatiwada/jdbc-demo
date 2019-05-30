package com.stackroute.jdbcdemo;

import java.sql.*;

public class ResultSetMetaDataDemo {
        public void getResultSetMetaData() {
            Connection connection = null;
            try {

                //register driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                //obtain connection
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
                PreparedStatement statement = connection.prepareStatement("select * from course where name='bootstrap' and duration=2");
                ResultSetMetaData resultSetMetaData = statement.getMetaData();

                System.out.println("Total number of columns: " + resultSetMetaData.getColumnCount());
                System.out.println("Column Name: " + resultSetMetaData.getColumnName(1));
                System.out.println("First Column Type Name: " + resultSetMetaData.getColumnTypeName(1));
                System.out.println("Last Column Type Name: " + resultSetMetaData.getColumnName(3));
                System.out.println("Catalog Name: " + resultSetMetaData.getCatalogName(3));
                System.out.println("Table Name: " + resultSetMetaData.getTableName(1));

                //connection.close();
            }
            catch (ClassNotFoundException classNotFound) {
                System.out.println("Exception thrown:" + classNotFound.getStackTrace());
            } catch (SQLException sqlException) {
                System.out.println("Exception thrown1:" + sqlException.getStackTrace());
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

