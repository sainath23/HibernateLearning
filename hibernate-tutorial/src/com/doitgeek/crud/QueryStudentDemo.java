package com.doitgeek.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.doitgeek.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		// Create Session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// Start transaction
			session.beginTransaction();
			
			 List<Student> studentList = session.createQuery("FROM Student").getResultList();
			 
			 for(Student student : studentList) {
				 System.out.println(student);
			 }
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			sessionFactory.close();
		}

	}

}
