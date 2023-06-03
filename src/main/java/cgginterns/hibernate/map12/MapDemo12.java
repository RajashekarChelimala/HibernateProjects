package cgginterns.hibernate.map12;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import cgginterns.hibernate.map.Answer;

public class MapDemo12 {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		
		Question12 q1 = new Question12();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java Programming");
		
		Answer12 a1 = new Answer12();
		a1.setAnswerId(343);
		a1.setAnswer("Java is a programming language");
		a1.setQuestion(q1);
		
		Answer12 a2 = new Answer12();
		a2.setAnswerId(344);
		a2.setAnswer("Java is a high level language");
		a2.setQuestion(q1);
		
		Answer12 a3 = new Answer12();
		a3.setAnswerId(345);
		a3.setAnswer("Java is platform independent...");
		a3.setQuestion(q1);
		
		ArrayList<Answer12> list = new ArrayList<>();
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
	
		q1.setAnswers(list);
		
		Session session = factory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(q1);
		session.save(a1);
		session.save(a2);
		session.save(a3);
		
		txn.commit();
		
		//fetching the details
		
		Question12 q = (Question12)session.get(Question12.class, 1212);
		System.out.println(q.getQuestion());
		List<Answer12> ans = q.getAnswers();
		
		for(Answer12 answer: ans) {
			System.out.println(answer.getAnswer());
		}
		
		session.close();
		factory.close();
	}

}
