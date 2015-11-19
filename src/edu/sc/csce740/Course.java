package edu.sc.csce740;

public class Course {

	//Class Variables
	private String name;
	private String id;
	private String numCredits;
		
	//General Constructor
	public Course(){
		name = "";
		id = "";
		numCredits = "";
	}
		
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumCredits() {
		return numCredits;
	}
	public void setNumCredits(String numCredits) {
		this.numCredits = numCredits;
	}
		
	//General ToString Method
	public String toString()
	{
		return "Courses [name=" + name + "" + ", id=" + id + ", numCredits=" + numCredits +"]";
	}
	
}
