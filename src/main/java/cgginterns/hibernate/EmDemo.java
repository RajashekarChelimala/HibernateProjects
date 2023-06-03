package cgginterns.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory factory = conf.buildSessionFactory();
		
		//create student object
		Student s = new Student();
		s.setId(103);
		s.setName("GHI");
		s.setCity("Bangalore");
		
		//create certificate object
		Certificate certi = new Certificate();
		
		certi.setCourse("EEE");
		certi.setDuration("4 years");
		
		s.setCerti(certi);
		
		System.out.println(s);
		
		Session session = factory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(s);
		
		System.out.println(s);
		
		txn.commit();
		session.close();
		factory.close();
	}

}
