package com.doitgeek.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.doitgeek.entity.Student;

public class DeleteStudentDemo {

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
			
			session.createQuery("DELETE FROM Student WHERE id = 2").executeUpdate();
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			sessionFactory.close();
		}

	}

}
