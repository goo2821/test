package com.lee.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	private static Connection connection = null;

    public static Connection getConnection() {
      
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://bs.mansu.kr:3306/userdb", "bose", "qhs1tjd2");
        } catch (SQLException e) {
            System.out.println("Ŀ�ؼ� sql ����: " + e.getMessage());
        } 
        return connection;

    }
}
