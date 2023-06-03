package cgg.hibernate.map22;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingM2M {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure();
		
		SessionFactory factory = config.buildSessionFactory();
		
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setEmpName("abc");
		
		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setEmpName("def");
		
		Project p1 = new Project();
		p1.setProjId(11);
		p1.setProjectName("Library Management");
		
		Project p2 = new Project();
		p2.setProjId(12);
		p2.setProjectName("Chat Bot");
		
		
		ArrayList<Employee> empArray = new ArrayList<Employee>();
		empArray.add(e1);
		empArray.add(e2);
		
		ArrayList<Employee> empArray1 = new ArrayList<Employee>();
		empArray1.add(e1);
		
		ArrayList<Employee> empArray2 = new ArrayList<Employee>();
		empArray2.add(e2);

		
		ArrayList<Project> projArray = new ArrayList<Project>();
		projArray.add(p1);
		projArray.add(p2);
		
		ArrayList<Project> projArray1 = new ArrayList<Project>();
		projArray1.add(p1);
		
		ArrayList<Project> projArray2 = new ArrayList<Project>();
		projArray2.add(p2);
		
		e1.setPList(projArray);
		e2.setPList(projArray2);
		
		p1.setEmpList(empArray);
		p2.setEmpList(empArray2);
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		
		tx.commit();
		
		Employee emp1 = session.get(Employee.class, 1);
		System.out.println(emp1.getEmpName());
		List<Project> epList = emp1.getPlist();
		for(Project i: epList) {
			System.out.println(i.getProjectName());
		}
		System.out.println("---------------------");
		
		Project proj11 = session.get(Project.class, 11);
		System.out.println(proj11.getProjectName());
		List<Employee> peList = proj11.getEmpList();
		for(Employee i:peList) {
			System.out.println(i.getEmpName());
		}
		session.close();
		factory.close();
	}

}
