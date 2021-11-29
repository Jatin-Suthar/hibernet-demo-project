package com.project.hibernate.demo;

import org.hibernate.cfg.Configuration;

import org.hibernate.*;
import com.project.hibernate.demo.entity.Student;

public class CreateStudentDemo {
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
		//create session factory 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save the java object in database
			//create the student object
			Student student = new Student("Jayesh", "Suthar", "jayeshsuthar300@gmail.com");
			System.out.println(ANSI_YELLOW+student.toString()+ANSI_RESET);
			//begin the transaction
			session.beginTransaction();
			//save the student object
			System.out.println(ANSI_GREEN+"Saving the student!"+ANSI_RESET);
			session.save(student);
			//commit the trasaction
			session.getTransaction().commit();
			System.out.println(ANSI_BLUE+"Successfully Commited!"+ANSI_RESET);
		}finally {
			factory.close();
		}
	}
}
