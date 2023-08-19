package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserUtil {

	public static Connection createConnection()
	{
		Connection conn=null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecommerce", "postgres","tops");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
