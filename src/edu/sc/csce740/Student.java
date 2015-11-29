package edu.sc.csce740;

public class Student {

	//Class Variables
	private String id;
	private String firstName;
	private String lastName;
	
	/**
     * Constructor that takes a 3 strings for an id, first name and last name for a student
     * @param id is the student's id
     * @param firstName is the students first name
     * @param lastName is the students last name
     * @return 
     * @throws 
     */
	public Student(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
     * Default constructor that sets the id, first name and last name for a student to default data
     * @param id is the student's id
     * @param firstName is the students first name
     * @param lastName is the students last name
     * @return 
     * @throws 
     */
	public Student() {
		this.id = "defaultId";
		this.firstName = "defaultFirstName";
		this.lastName = "defaultLastName";
	}

	/**
     * Method to return the student's id 
     * @param 
     * @return id of the student
     * @throws 
     */
	public String getId() {
		return id;
	}
	
	/**
     * Method to set the student id
     * @param id of the student
     * @return 
     * @throws 
     */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
     * Method to return the first name of the student 
     * @param 
     * @return firstName
     * @throws 
     */
	public String getFirstName() {
		return firstName;
	}
	
	/**
     * Method to set the first name of the student 
     * @param firstName is of type string
     * @return 
     * @throws 
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
     * Method to return the last name of the student  
     * @param 
     * @return lastName
     * @throws 
     */
	public String getLastName() {
		return lastName;
	}
	
	/**
     * Method to set the last name of a student
     * @param lastName of type string
     * @return 
     * @throws 
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
     * Method to return the a string of all the private members in the student class
     * @param 
     * @return a string composed of id, firstName and lastName
     * @throws 
     */
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
}
