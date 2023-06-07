package cgg.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//HQL
		
//		String query = "from Student";
//		String query = "from Student where city='Hyd'";
//		String query = "from Student where city=:x and name=:n";
//		String query = "from Student as s where s.city=:x and s.name=:n";
//		Query q = session.createQuery(query);
//		q.setParameter("x", "Hyd");
//		q.setParameter("n", "DEF");
		//single result - unique
		//multiple results - list
		
//		List<Student> list = q.list();
//		
//		for (Student student : list) {
//			System.out.println(student.getName()+" : "+student.getCity()+" : "+ student.getCerti().getCourse());
//		}
		
		//delete
//		Query q1 = session.createQuery("delete from Student s where s.city=:x");
//		q1.setParameter("x", "Hyd");
//		int r = q1.executeUpdate();
//		System.out.println("Deleted: "+r);
		
		
		//update
//		Query q1 = session.createQuery("update Student set city=:x where name='GHI'");
//		q1.setParameter("x", "Hyd");
//		int r = q1.executeUpdate();
//		System.out.println("Updated: "+r);
//		
//		System.out.println("Deleted Successfully!!");
//		
//		
//		tx.commit();
		
		//join query
		
		Query q = session.createQuery("select b.brandId, b.brandName, p.productName from Brand as b INNER JOIN b.products as p");
		List<Object []> list = q.getResultList();
		
		
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		
		session.close();
		factory.close();
		
	}

}
