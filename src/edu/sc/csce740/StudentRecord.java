package edu.sc.csce740;

public class StudentRecord {

	//Andrew Poop2
	
	//Class Variables
	private Student student;
	
	private String department;
	
	private Degree degreeSought;
	private Degree certificateSought;
	private Degree previousDegrees;
	
	private Term termBegan;
	private Term graduation;
	private Term term;
	
	private Professor advisors;
	private Professor committee;
	
	private CourseSR coursesTaken;
	private Milestone milestonesSet;
	
	private String notes;
	
	public StudentRecord(Student student, String department,
			Degree degreeSought, Degree certificateSought,
			Degree previousDegrees, Term termBegan, Term graduation, Term term,
			Professor advisors, Professor committee, CourseSR coursesTaken,
			Milestone milestonesSet, String notes) {
		super();
		this.student = student;
		this.department = department;
		this.degreeSought = degreeSought;
		this.certificateSought = certificateSought;
		this.previousDegrees = previousDegrees;
		this.termBegan = termBegan;
		this.graduation = graduation;
		this.term = term;
		this.advisors = advisors;
		this.committee = committee;
		this.coursesTaken = coursesTaken;
		this.milestonesSet = milestonesSet;
		this.notes = notes;
	}

	//Getters and Setters
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Degree getDegreeSought() {
		return degreeSought;
	}

	public void setDegreeSought(Degree degreeSought) {
		this.degreeSought = degreeSought;
	}

	public Degree getCertificateSought() {
		return certificateSought;
	}

	public void setCertificateSought(Degree certificateSought) {
		this.certificateSought = certificateSought;
	}

	public Degree getPreviousDegrees() {
		return previousDegrees;
	}

	public void setPreviousDegrees(Degree previousDegrees) {
		this.previousDegrees = previousDegrees;
	}

	public Term getTermBegan() {
		return termBegan;
	}

	public void setTermBegan(Term termBegan) {
		this.termBegan = termBegan;
	}

	public Term getGraduation() {
		return graduation;
	}

	public void setGraduation(Term graduation) {
		this.graduation = graduation;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Professor getAdvisors() {
		return advisors;
	}

	public void setAdvisors(Professor advisors) {
		this.advisors = advisors;
	}

	public Professor getCommittee() {
		return committee;
	}

	public void setCommittee(Professor committee) {
		this.committee = committee;
	}

	public CourseSR getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(CourseSR coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public Milestone getMilestonesSet() {
		return milestonesSet;
	}

	public void setMilestonesSet(Milestone milestonesSet) {
		this.milestonesSet = milestonesSet;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	//General ToString Method
	@Override
	public String toString() {
		return "StudentRecord [student=" + student + ", department="
				+ department + ", degreeSought=" + degreeSought
				+ ", certificateSought=" + certificateSought
				+ ", previousDegrees=" + previousDegrees + ", termBegan="
				+ termBegan + ", graduation=" + graduation + ", term=" + term
				+ ", advisors=" + advisors + ", committee=" + committee
				+ ", coursesTaken=" + coursesTaken + ", milestonesSet="
				+ milestonesSet + ", notes=" + notes + "]";
	}
		
}
