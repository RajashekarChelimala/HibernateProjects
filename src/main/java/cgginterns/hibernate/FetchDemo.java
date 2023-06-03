package cgginterns.hibernate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//Fetching Student data
//		Student s = (Student)session.load(Student.class, 2);
//		System.out.println(s);
		
		Address a = (Address)session.get(Address.class, 1);
//		System.out.println(a);
//		System.out.println(a.getStreet()+" : "+a.getCity());
		
		//fetching image..
		
		byte[] image = a.getImage();
		try(FileOutputStream fos = new FileOutputStream("src/main/java/fetchedrohit.jpg");){
			fos.write(image);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		session.close();
		factory.close();
	}
}