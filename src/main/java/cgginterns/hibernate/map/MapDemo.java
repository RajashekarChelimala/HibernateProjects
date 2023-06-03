package cgginterns.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		
		//creating question object
		
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");

		Answer a1 = new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("Java is a programming Language");
		
		q1.setAnswer(a1);
		a1.setQuestion(q1);
		
		//creating another object
		
		Question q2 = new Question();
		q2.setQuestionId(121);
		q2.setQuestion("What is Collection?");

		Answer a2 = new Answer();
		a2.setAnswerId(240);
		a2.setAnswer("Collection is a Java Framework");
		
		q2.setAnswer(a2);
		a2.setQuestion(q2);
		
		Session session = factory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(q1);
		session.save(q2);
		
		session.save(a1);
		session.save(a2);
		
		txn.commit();
		
		//fetching objects
		
		Question q = (Question)session.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().getAnswer());
		System.out.println("---------------------------------------");
		Answer a = (Answer)session.get(Answer.class, 240);
		System.out.println(a.getAnswer());
		System.out.println(a.getQuestion().getQuestion());
		
		session.close();
		factory.close();
		
	}

}
