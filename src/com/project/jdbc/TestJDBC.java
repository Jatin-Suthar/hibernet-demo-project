package com.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println(ANSI_BLUE + " Connecting to the database : " + url + ANSI_RESET);
			Connection myConn = DriverManager.getConnection(url, user, pass);
			System.out.println(ANSI_GREEN + " Connection Successfull!!! " + ANSI_RESET);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
