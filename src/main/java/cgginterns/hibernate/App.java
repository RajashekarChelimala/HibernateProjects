package cgginterns.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Created" );
        
        Configuration confg = new Configuration();
        confg.configure();
        SessionFactory factory = confg.buildSessionFactory();
        
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        //creating student object
        Student student = new Student();
        student.setId(2);
        student.setName("DEF");
        student.setCity("Hyd");
        
        System.out.println(student);
        
        Address ad = new Address();
        ad.setStreet("street2");
        ad.setCity("Hyd");
        ad.setOpen(true);
        ad.setX(12.456);
        ad.setAdd_date(new Date());
        
        //Reading and Storing image:
        
        try(FileInputStream fis = new FileInputStream("src/main/java/rohit.jpg")){
        	byte[] data = new byte[fis.available()];
        	fis.read(data);
        	ad.setImage(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(student);
        session.save(ad);
        
        tx.commit();
        
        session.close();
        factory.close();
        System.out.println("Done..");
    }
}