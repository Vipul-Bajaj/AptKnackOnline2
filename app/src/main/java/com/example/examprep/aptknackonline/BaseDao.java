package com.example.examprep.aptknackonline;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    /**
     * Constants-----------------------------------------------
     */
    protected static final String DB_HOST = "sql12.freemysqlhosting.net";  // "www.db4free.net";
    protected static final String DB_USER = "sql12225659"; // "testoadmin";
    protected static final String DB_PASS = "HPmFPPjU1e"; // "alphaalpha";
    protected static final String DB_NAME = "sql12225659"; // "testoprepdb";

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
        res = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME, DB_USER, DB_PASS);
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
