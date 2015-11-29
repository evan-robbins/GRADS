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
	
	/**
     * Default constructor to create a student record 
     * @return 
     * @throws 
     */
	public StudentRecord()
	{

	}
	
	/**
     * Method to get the certificate sought after
     * @param student object which holds relevant student info
     * @param department or major string
     * @param degreeeSought is the degree the student is seeking 
     * @param certificateSought is the certificate being sought after
     * @param previousDegress has a list of all degrees gotten by the student
     * @param termBegan is the term the student started the degree program
     * @param advisors is a list of all the students advisors
     * @param committee is a list of all the students committee members
     * @param coursesTaken is a list of all courses taken by the student
     * @param milestoneSet a list of all milestones the student has been passed
     * @param notes a list of notes to add to the student record
     * @return 
     * @throws 
     */
	public StudentRecord(Student student, String department,
			Degree degreeSought, Degree certificateSought,
			List<Degree> previousDegrees, Term termBegan,
			List<Professor> advisors, List<Professor> committee, List<CourseTaken> coursesTaken,
			List<Milestone> milestonesSet, List<String> notes) {
		
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

	/**
     * Method to get the student object
     * @param 
     * @return the student object
     * @throws 
     */
	public Student getStudent() {
		return student;
	}

	/**
     * Method to set the student object
     * @param a student object
     * @return 
     * @throws 
     */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
     * Method to return the department or major 
     * @param 
     * @return department
     * @throws 
     */
	public String getDepartment() {
		return department;
	}

	/**
     * Method to set the department string
     * @param department string 
     * @return 
     * @throws 
     */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
     * Method to get the degree sought
     * @param 
     * @return degreeSought
     * @throws 
     */
	public Degree getDegreeSought() {
		return degreeSought;
	}

	/**
     * Method to set the degreeSought object
     * @param degreeeSought object of type Degree
     * @return 
     * @throws 
     */
	public void setDegreeSought(Degree degreeSought) {
		this.degreeSought = degreeSought;
	}

	/**
     * Method to get the certificate sought after
     * @param 
     * @return certificateSought
     * @throws 
     */
	public Degree getCertificateSought() {
		return certificateSought;
	}

	/**
     * Method to set the certificateSought object
     * @param certificateSought object of type Degree
     * @return 
     * @throws 
     */
	public void setCertificateSought(Degree certificateSought) {
		this.certificateSought = certificateSought;
	}

	/**
     * Method to get previous degress taken
     * @param 
     * @return previousDegress
     * @throws 
     */
	public List<Degree> getPreviousDegrees() {
		return previousDegrees;
	}

	/**
     * Method to set the list of previousDegrees
     * @param previousDegrees list that holds objects of type Degree
     * @return 
     * @throws 
     */
	public void setPreviousDegrees(List<Degree> previousDegrees) {
		this.previousDegrees = previousDegrees;
	}

	/**
     * Method to get the term the student started
     * @param 
     * @return termBegan
     * @throws 
     */
	public Term getTermBegan() {
		return termBegan;
	}

	/**
     * Method to set the term the degree sought was started
     * @param termBegan a Term object
     * @return 
     * @throws 
     */
	public void setTermBegan(Term termBegan) {
		this.termBegan = termBegan;
	}

	/**
     * Method to get the list of advisors
     * @param 
     * @return advisors
     * @throws 
     */
	public List<Professor> getAdvisors() {
		return advisors;
	}

	/**
     * Method to set the advisors list which holds several different professors
     * @param advisors a list of objects of type professor
     * @return 
     * @throws 
     */
	public void setAdvisors(List<Professor> advisors) {
		this.advisors = advisors;
	}
	
	/**
     * Method to get the list of committee memebers for a student
     * @param 
     * @return comittee
     * @throws 
     */
	public List<Professor> getCommittee() {
		return committee;
	}

	/**
     * Method to set the committee list which holds several different professors
     * @param committee a list of objects of type professor
     * @return 
     * @throws 
     */
	public void setCommittee(List<Professor> committee) {
		this.committee = committee;
	}

	/**
     * Method to get the list of courses taken 
     * @param 
     * @return coursesTaken 
     * @throws 
     */
	public List<CourseTaken> getCoursesTaken() {
		return coursesTaken;
	}

	/**
     * Method to set the coursesTaken list which holds several different classes
     * @param coursesTaken a list of objects of type CourseTaken
     * @return 
     * @throws 
     */
	public void setCoursesTaken(List<CourseTaken> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	/**
     * Method to get the milestone list
     * @param 
     * @return milestones
     * @throws 
     */
	public List<Milestone> getMilestonesSet() {
		return milestonesSet;
	}

	/**
     * Method to set the milestonesSet list which holds several different milestones that have been accomplished
     * @param milestonesSet a list of objects of type Milestone
     * @return 
     * @throws 
     */
	public void setMilestonesSet(List<Milestone> milestonesSet) {
		this.milestonesSet = milestonesSet;
	}

	/**
     * Method to get notes
     * @param 
     * @return the notes
     * @throws 
     */
	public List<String> getNotes() {
		return notes;
	}
	
	/**
     * Sets the value of notes
     * @param notes is the list of notes 
     * @return 
     * @throws 
     */
	public void setNotes(List<String> notes) {
		this.notes = notes;
	}
	
	/**
     * Adds a note to the notes list 
     * @param note is the note to add to the end of the list
     * @return 
     * @throws 
     */
	public void addNote(String note) {
		this.notes.add(note);
	}
	
	
	
	/**
     * To String method to print out values in the all fields
     * @param 
     * @return 
     * @throws 
     */
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
