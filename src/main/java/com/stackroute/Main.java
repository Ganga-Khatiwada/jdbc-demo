package com.stackroute;

import com.stackroute.jdbcdemo.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {

        DataManager dataManager=new DataManager();
        dataManager.getAllCourse();

//        PreparedStatementDemo preparedStatementDemo=new PreparedStatementDemo();
//        preparedStatementDemo.getCourseByName("Core Java");
//
//        DatabaseMetaDataDemo databaseMetadataDemo = new DatabaseMetaDataDemo();
//        databaseMetadataDemo.getDatabaseMetaData();
//
//        ResultSetMetaDataDemo resultSetMetaDataDemo = new ResultSetMetaDataDemo();
//        resultSetMetaDataDemo.getResultSetMetaData();
//
//        JDBCBatchProcessingDemo jdbcBatchProcessingDemo = new JDBCBatchProcessingDemo();
//        jdbcBatchProcessingDemo.getJDBCBatchProcessing();
//
//        JDBCTransactionDemo jdbcTransactionDemo = new JDBCTransactionDemo();
//        jdbcTransactionDemo.getJDBCTransaction();
//
//        RowSetDemo rowsetDemo = new RowSetDemo();
//        rowsetDemo.getAllCourse();
//        rowsetDemo.getCourseByName("Core Java");
//        rowsetDemo.getCourseByNameAndDuration("bootstrap",2);
    }
}
