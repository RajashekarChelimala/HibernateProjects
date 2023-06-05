package cgginterns.hibernate.map12;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BrandProductMapDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//creating brand
//		Brand brand = new Brand();
//		brand.setBrandId(1);
//		brand.setBrandName("Tata");
//		
//		//creating product
//		Product product = new Product();
//		product.setProductId(11);
//		product.setProductName("Tata car");
//		product.setBrand(brand);
//		
//		Product product1 = new Product();
//		product1.setProductId(12);
//		product1.setProductName("Tata salt");
//		product1.setBrand(brand);
//		
//		Product product2 = new Product();
//		product2.setProductId(13);
//		product2.setProductName("Tata Water");
//		product2.setBrand(brand);
//		
//		
//		ArrayList<Product> products = new ArrayList<>();
//		
//		products.add(product);
//		products.add(product1);
//		products.add(product2);
//		
//		brand.setProducts(products);
//		
		Session session = factory.openSession();
		
//		Transaction txn = session.beginTransaction();
//		
//		
//		session.save(brand);
//		
//		session.save(product);
//		session.save(product1);
//		session.save(product2);
//		
//		
//		txn.commit();
		
		Brand bd = (Brand)session.get(Brand.class, 1);
		
		System.out.println(bd.getBrandName());
		
//		List<Product> prdct = bd.getProducts();
		
//		for(Product p : prdct) {
//			System.out.println(p.getProductName());
//		}
//		
		session.close();
		factory.close();
		
	}

}
