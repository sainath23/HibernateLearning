package com.doitgeek.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.doitgeek.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		// Create Session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// Create Student object
			System.out.println("Creating student...");
			//Student student = new Student("Sainath", "Parkar", "sainath@gmail.com");
			Student student1 = new Student("Demo", "Demo", "demo@gmail.com");
			Student student2 = new Student("Saurabh", "Mestry", "saurabh@gmail.com");
			Student student3 = new Student("Gaurav", "Rasal", "gaurav@gmail.com");
			Student student4 = new Student("Pratik", "Sutar", "pratik@gmail.com");
			Student student5 = new Student("Shahid", "Ansari", "shahid@gmail.com");
			
			// Start transaction
			session.beginTransaction();
			
			// Save Student object
			System.out.println("Saving student...");
			//session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);
			session.save(student5);
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			sessionFactory.close();
		}

	}

}
