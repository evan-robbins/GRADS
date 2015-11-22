package edu.sc.csce740;

import java.util.List;

public class StudentRecord {
	
	//Class Variables
	private Student student;
	private String department; //all upper case and no spaces with under scores
	private Term termBegan;
	
	private Degree degreeSought;
	private Degree certificateSought;
	private List<Degree> previousDegrees;
	
	
	private List<Professor> advisors;
	private List<Professor> committee;
	
	private List<CourseTaken> coursesTaken;
	
	private List<Milestone> milestonesSet;
	
	private List<String> notes;
	
	public StudentRecord()
	{
//		Degree tempDegree = new Degree();
//		Professor prof = new Professor();
//		CourseTaken courseTaken = new CourseTaken();
//		Milestone milestone = new Milestone();
//		
		this.student =  new Student();
		this.department = "";
		this.termBegan = new Term();
		
		this.degreeSought = new Degree();
		this.certificateSought =  new Degree();
//		this.previousDegrees.add( tempDegree);

//		this.advisors.add(prof);
//		this.committee.add(prof);
//		this.coursesTaken.add(courseTaken);
//		this.milestonesSet.add(milestone);
//		this.notes.add("defaultNote");
	}
	
	public StudentRecord(Student student, String department,
			Degree degreeSought, Degree certificateSought,
			List<Degree> previousDegrees, Term termBegan, Term graduation, Term term,
			List<Professor> advisors, List<Professor> committee, List<CourseTaken> coursesTaken,
			List<Milestone> milestonesSet, List<String> notes) {
		super();
		this.student = student;
		this.department = department;
		
		this.degreeSought = degreeSought;
		this.certificateSought = certificateSought;
		this.previousDegrees = previousDegrees;

		this.advisors = advisors;
		this.committee = committee;
		this.coursesTaken = coursesTaken;
		this.milestonesSet = milestonesSet;
		this.notes = notes;
	}

	public StudentRecord(StudentRecord studentRecord) {
		this.student = studentRecord.getStudent();
		this.department = studentRecord.getDepartment();
		
		this.degreeSought = studentRecord.getDegreeSought();
		this.certificateSought = studentRecord.getCertificateSought();
		this.previousDegrees = studentRecord.getPreviousDegrees();

		this.advisors = studentRecord.getAdvisors();
		this.committee = studentRecord.getCommittee();
		this.coursesTaken = studentRecord.getCoursesTaken();
		this.milestonesSet = studentRecord.getMilestonesSet();
		this.notes = studentRecord.getNotes();
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

	public List<Degree> getPreviousDegrees() {
		return previousDegrees;
	}

	public void setPreviousDegrees(List<Degree> previousDegrees) {
		this.previousDegrees = previousDegrees;
	}

	public Term getTermBegan() {
		return termBegan;
	}

	public void setTermBegan(Term termBegan) {
		this.termBegan = termBegan;
	}


	public List<Professor> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(List<Professor> advisors) {
		this.advisors = advisors;
	}

	public List<Professor> getCommittee() {
		return committee;
	}

	public void setCommittee(List<Professor> committee) {
		this.committee = committee;
	}

	public List<CourseTaken> getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(List<CourseTaken> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public List<Milestone> getMilestonesSet() {
		return milestonesSet;
	}

	public void setMilestonesSet(List<Milestone> milestonesSet) {
		this.milestonesSet = milestonesSet;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}
	public void addNote(String note) {
		this.notes.add(note);
	}
	
	public String toString() {
		return "StudentRecord [student=" + student + ", department="
				+ department + ", degreeSought=" + degreeSought
				+ ", certificateSought=" + certificateSought
				+ ", previousDegrees=" + previousDegrees + ", termBegan="
				+ termBegan +", advisors=" + advisors + ", committee=" + committee
				+ ", coursesTaken=" + coursesTaken + ", milestonesSet="
				+ milestonesSet + ", notes=" + notes + "]";
	}
		
}
