package cgginterns.hibernate.map12;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import cgginterns.hibernate.map.Answer;

@Entity
public class Question12 {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
	
	@OneToMany
	private List<Answer12> answers;
	
	public List<Answer12> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer12> answers) {
		this.answers = answers;
	}
	public Question12(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}
	public Question12() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + "]";
	}
	
}
