package edu.sc.csce740;

import java.util.List;

public class Details {
	
	//Class Variables
	private double gpa;
	private List<Course> courses;
	private List<Milestone> milestones;
	private List<String> notes;
	
	//General Constructor
	public Details(double gpa, List<Courses> courses, List<Milestone> milestones, List<String> notes) {
		super();
		this.gpa = gpa;
		this.courses = courses;
		this.milestones = milestones;
		this.notes = notes;
	}

	//Getters and Setters
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public List<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	//General ToString Method
	@Override
	public String toString() {
		return "Details [gpa=" + gpa + ", courses=" + courses + ", milestones=" + milestones + ", notes=" + notes + "]";
	}
	
	
	
	
	
	

}
