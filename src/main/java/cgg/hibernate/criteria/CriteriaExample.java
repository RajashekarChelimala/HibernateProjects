package cgg.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import cgginterns.hibernate.Student;
import cgginterns.hibernate.map12.Brand;

public class CriteriaExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		
//		Criteria c = session.createCriteria(Student.class);
//		c.add(Restrictions.eq("certi.course", "EEE"));
//		c.add(Restrictions.gt("id", 10));
//		c.add(Restrictions.like("name", "J%"));
		
		Criteria c = session.createCriteria(Brand.class);
		List<Brand> list = c.list();
		
		for (Brand s : list) {
			System.out.println(s);
		}
		
		session.close();
		factory.close();
	}

}
