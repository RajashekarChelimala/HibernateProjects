package cgg.hibernate.secondlevelcache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Student;
import cgginterns.hibernate.map12.Brand;
import cgginterns.hibernate.map12.Product;

public class test {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
//		Student s1 = session.get(Student.class, 1);
//		System.out.println("Session 1 :");
//		System.out.println(s1);
		Brand b1 = session.get(Brand.class, 1);
		System.out.println(b1.getBrandName());
		
		List<Product> products = b1.getProducts();
		
		for (Product product : products) {
			System.out.println(product.getProductName());
		}
		
		session.close();
		
		Session session2 = factory.openSession();
		
//		Student s2 = session2.get(Student.class, 1);
//		System.out.println("Session 2 :");
//		System.out.println(s2);
		
		Brand b2 = session2.get(Brand.class, 1);
		System.out.println(b2.getBrandName());
		
		List<Product> products2 = b2.getProducts();
		
		for (Product product : products2) {
			System.out.println(product.getProductName());
		}
		
		session2.close();
		factory.close();
	}

}
