package cgg.hibernate.cascade;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.map12.Brand;
import cgginterns.hibernate.map12.Product;

public class CascadeExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		
//		Brand b1 = new Brand();
//		b1.setBrandId(2);
//		b1.setBrandName("Samsung");
//		
//		Product p1 = new Product();
//		p1.setProductId(21);
//		p1.setProductName("Galaxy s3");
//		p1.setBrand(b1);
//		Product p2 = new Product();
//		p2.setProductId(22);
//		p2.setProductName("samsung tv");
//		p2.setBrand(b1);
//		Product p3 = new Product();
//		p3.setProductId(23);
//		p3.setProductName("samsung fridge");
//		p3.setBrand(b1);
//		
//		Brand b2 = new Brand();
//		b2.setBrandId(1);
//		b2.setBrandName("Apple");
//	
//		Product p21 = new Product();
//		p21.setProductId(31);
//		p21.setProductName("iPhone");
//		p21.setBrand(b2);
//		Product p22 = new Product();
//		p22.setProductId(32);
//		p22.setProductName("iPad");
//		p22.setBrand(b2);
//		Product p23 = new Product();
//		p23.setProductId(33);
//		p23.setProductName("Mac Book");
//		p23.setBrand(b2);
		
//		ArrayList<Product> list1 = new ArrayList<Product>();
//		ArrayList<Product> list2 = new ArrayList<Product>();
		
//		list1.add(p1);
//		list1.add(p2);
//		list1.add(p3);
		
//		list2.add(p21);
//		list2.add(p22);
//		list2.add(p23);
//		b1.setProducts(list1);
//		b2.setProducts(list2);
//				
		Transaction tx = session.beginTransaction();
		
//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
//		session.save(b1);
//		session.save(b2);
		
		Query query = session.createQuery("delete from Brand where brandId=:x");
		query.setParameter("x", 2);
		
		int r = query.executeUpdate();
		
		System.out.println("Deleted : "+r);
//        Brand brand = session.get(Brand.class, 1);
//        session.delete(brand);
		tx.commit();
		
		session.close();
		factory.close();
	}

}
