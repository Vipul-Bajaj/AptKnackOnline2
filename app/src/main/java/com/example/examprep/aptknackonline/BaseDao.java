package com.example.examprep.aptknackonline;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    /**
     * Constants-----------------------------------------------
     */
    protected static final String DB_HOST = "sql12.freesqldatabase.com";  // "www.db4free.net";
    protected static final String DB_USER = "sql12221983"; // "testoadmin";
    protected static final String DB_PASS = "t7mauXLJKT"; // "alphaalpha";
    protected static final String DB_NAME = "sql12221983"; // "testoprepdb";

    /**
     * ---------------------------------------------------------
     * Gets connection from driver
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected static Connection getConn() throws ClassNotFoundException, SQLException {

        Connection res = null;
        Class.forName("com.mysql.jdbc.Driver");
        res = DriverManager.getConnection("jdbc:mysql://192.168.43.33/test", "root", "root");

        Log.d("vipul", "getConn: connected to database");
        return res;
    }

    protected static void closeConn(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
