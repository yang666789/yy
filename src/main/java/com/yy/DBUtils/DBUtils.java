package com.yy.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String DRIVENAME="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/testdata?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
    private static final String NAME="root";
    private static final String PASSWORD="yangyishiwo0413";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVENAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
