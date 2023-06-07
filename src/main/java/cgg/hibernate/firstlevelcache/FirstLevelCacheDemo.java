package cgg.hibernate.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Student;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		
		Student s = session.get(Student.class, 1);
		System.out.println(s);
		System.out.println("Working on....");
		System.out.println(session.contains(s));
		Student student =session.get(Student.class, 2);
		System.out.println(student);
		System.out.println("Done...");
		session.close();
		factory.close();
	}

}
