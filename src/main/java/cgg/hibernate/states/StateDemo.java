package cgg.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Certificate;
import cgginterns.hibernate.Student;

public class StateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Student s1 = new Student();
		s1.setId(101);
		s1.setName("Rajashekar");
		s1.setCity("Hyd");

		Certificate c1 = new Certificate();
		
		c1.setCourse("Java Full Stack");
		c1.setDuration("5 Months");
		
		s1.setCerti(c1);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(s1);
		//Student : Persistent: session, database
		
		s1.setName("Ch.Rajashekar");
		
		//student - removed State
		session.delete(s1);
		
		
		
		tx.commit();
		session.close();
		//student detached - session closed
		
		s1.setName("DEF");
		System.out.println(s1.getName());
		
		
		factory.close();
	}

}
