package com.doitgeek.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.doitgeek.entity.Student;

public class UpdateStudentDemo {

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
			
			Student student = session.get(Student.class, 1);
			student.setEmail("sainath@doitgeek.com");
			System.out.println(student);
			
			session.createQuery("UPDATE Student SET email = 'sabby@doitgeek.com' WHERE id = 3").executeUpdate();
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			sessionFactory.close();
		}

	}

}
