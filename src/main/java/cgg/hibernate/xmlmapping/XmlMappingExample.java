package cgg.hibernate.xmlmapping;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlMappingExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		
//		Person person = new Person(110,"ABC","Hyd","1234567890");
		
		Department d1 = new Department();
		d1.setDeptName("Development");
		
		Department d2 = new Department();
		d2.setDeptName("Network");
		
		Employeee e1 = new Employeee();
		e1.setName("Rajashekar");
		e1.setSalary(100000);
		e1.setDept(d1);
		
		Employeee e2 = new Employeee();
		e2.setName("Farooq");
		e2.setSalary(120000);
		e2.setDept(d1);
		
		Employeee e3 = new Employeee();
		e3.setName("Vamshi");
		e3.setSalary(110000);
		e3.setDept(d2);
		
		ArrayList<Employeee> emplist1 = new ArrayList<>();
		ArrayList<Employeee> emplist2 = new ArrayList<>();
		
		emplist1.add(e1);
		emplist1.add(e2);
		
		emplist2.add(e3);

		d1.setEmployees(emplist1);
		d2.setEmployees(emplist2);
		Transaction tx = session.beginTransaction();
		
//		session.save(person);
		session.save(d1);
		session.save(d2);
		
		tx.commit();
		session.close();
		factory.close();
	}

}