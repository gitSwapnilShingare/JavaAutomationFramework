package com.uiFramework.Testbase.helper.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper {

    private static String url = "";
    private static String driverName = "";
    private static String userName = "";
    private static String password = "";
    private static Connection connection;
    private static DataBaseHelper instance = null;

    /**
     * Constructor to create a new instance of DataBaseHelper and initialize the database connection.
     */
    public DataBaseHelper() {
        connection = getSingleInstanceConnection();
    }

    /**
     * Gets a singleton instance of the DataBaseHelper class.
     * @return A singleton instance of DataBaseHelper.
     */
    public static DataBaseHelper getInstance() {
        if (instance == null) {
            instance = new DataBaseHelper();
        }
        return instance;
    }

    /**
     * Initializes and retrieves a single database connection instance.
     * @return A database Connection instance.
     */
    private Connection getSingleInstanceConnection() {
        try {
            Class.forName(driverName);
            try {
                connection = DriverManager.getConnection(url, userName, password);
                if (connection != null) {
                    // Connection successful
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Retrieves the database Connection instance.
     * @return The database Connection instance.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Executes a database query and returns a ResultSet.
     * @param dbQuery The SQL query to be executed.
     * @return A ResultSet containing the results of the query.
     */
    public static ResultSet getResultSet(String dbQuery) {
        instance = DataBaseHelper.getInstance();
        connection = instance.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(dbQuery);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
