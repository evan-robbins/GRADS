package edu.sc.csce740;

public class Professor {

	//Class Variables
	private String department;
	private String firstName;
	private String lastName;
	
	/**
     * Constructor that takes a 3 strings for an department, first name and last name for a professor
     * @param department is the professor's department
     * @param firstName is the professor's first name
     * @param lastName is the professor's last name
     * @return 
     * @throws 
     */
	public Professor(String department, String firstName, String lastName) {
		super();
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
     * Default constructor that takes no arguments and sets the data to be blank
     * @param 
     * @return 
     * @throws 
     */
	public Professor() {
		this.department = "";
		this.firstName = "";
		this.lastName = "";
	}

	/**
     * Method to return the department of the professor 
     * @param 
     * @return department is  a string
     * @throws 
     */
	public String getDepartment() {
		return department;
	}
	
	/**
     * Method to set the department of a professor
     * @param department is a string
     * @return  
     * @throws 
     */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
     * Method to return the first name of the professor 
     * @param 
     * @return firstName is  a string
     * @throws 
     */
	public String getFirstName() {
		return firstName;
	}
	
	/**
     * Method to set the first name of a professor
     * @param firstName is a string
     * @return 
     * @throws 
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
     * Method to return the first name of the professor 
     * @param 
     * @return firstName is a string
     * @throws 
     */
	public String getLastName() {
		return lastName;
	}
	
	/**
     * Method to set the last name of a professor
     * @param lastName is a string
     * @return 
     * @throws 
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Professor [department=" + department + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	/**
     * To string method that returns a string of all the private members in the professor class
     * @param 
     * @return a string 
     * @throws 
     */

		
}
