package com.example.examprep.aptknackonline.DataBase;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    protected static final String DB_HOST = "208.91.199.11";
    protected static final String DB_USER = "peeraptitude";
    protected static final String DB_PASS = "jif7C8@4";
    protected static final String DB_NAME = "peeraptitutdedb";

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
        Log.d("Vipul", "getConn: got a request");
        res = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME, DB_USER, DB_PASS);
        Log.d("Vipul", "getConn: " + res);
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
