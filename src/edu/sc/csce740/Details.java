package edu.sc.csce740;

import java.util.List;

public class Details {
	
	//Class Variables
	private String gpa;
	private List<CourseTaken> courseTaken;
	private List<Milestone> milestones;
	private List<String> notes;
	
    /**
     * Returns a Details object with courseTaken, milestones, and notes
     * @param 
     * @return Returns a Details object with courseTaken, milestones, and notes
     * @throws 
     */
	public Details(String gpa, List<CourseTaken> courseTaken, List<Milestone> milestones, List<String> notes) {
		super();
		this.gpa = gpa;
		this.courseTaken = courseTaken;
		this.milestones = milestones;
		this.notes = notes;
	}
	
	 /**
     * Returns an empty Details object
     * @param 
     * @return Returns an empty Details object
     * @throws 
     */
	public Details(){
		
	}

    /**
     * Returns the String gpa
     * @param 
     * @return the String gpa
     * @throws 
     */
	public String getGpa() {
		return gpa;
	}

    /**
     * Sets the String gpa
     * @param  gpa sets the value of the gpa variable
     * @return 
     * @throws 
     */
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	/**
     * Returns the List<CourseTaken> courseTaken
     * @param 
     * @return the List<CourseTaken> courseTaken
     * @throws 
     */
	public List<CourseTaken> getCourseTaken() {
		return courseTaken;
	}

    /**
     * Sets the courseTaken object
     * @param  courseTaken sets the value of the courseTaken variable
     * @return 
     * @throws 
     */
	public void setCourseTaken(List<CourseTaken> CourseTaken) {
		this.courseTaken = CourseTaken;
	}

	/**
     * Returns the List<Milestone> milestones
     * @param 
     * @return the List<Milestone> milestones
     * @throws 
     */
	public List<Milestone> getMilestones() {
		return milestones;
	}

	/**
     * Sets the milestones
     * @param  milestones sets the value of the milestones variable
     * @return 
     * @throws 
     */
	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	/**
     * Returns the List<String> notes
     * @param 
     * @return the List<String> notes
     * @throws 
     */
	public List<String> getNotes() {
		return notes;
	}

	/**
     * Sets the notes
     * @param  notes sets the value of the notes variable
     * @return 
     * @throws 
     */
	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

    /**
     * Returns a string containing the value of all of the class variables
     * @param 
     * @return Returns a string containing the value of all of the class variables
     * @throws 
     */
	public String toString() {
		return "Details [gpa=" + gpa + ", CourseTaken=" + courseTaken + ", milestones=" + milestones + ", notes=" + notes + "]";
	}
	
	
	
	
	
	

}
