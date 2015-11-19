package edu.sc.csce740;

public class Courses {

	//Class Variables
	private Course course;
	private Term term;
	private String grade;
	
	//General Constructor
	public Courses(Course course, Term term, String grade) {
		super();
		this.course = course;
		this.term = term;
		this.grade = grade;
	}

	//Getters and Setters
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	//General ToString Method
	@Override
	public String toString() {
		return "Courses [course=" + course + ", term=" + term + ", grade=" + grade + "]";
	}
		
}
