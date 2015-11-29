package edu.sc.csce740;


public class User {

	//Class Variables
	private String id;
	private String firstName;
	private String lastName;
	private String role;
	private String department;
	
	/**
     * Default constructor that sets all values to null
     */
	public User ()
	{
		id = "";
		firstName = "";
		lastName = "";
		role = "";
		department = "";
	}
	
	
	/**
     * Used to get the student's id
     * @return the student's id
     */
	public String getId() {
		return id;
	}
	
	/**
     * Used to set the student's id
     * @param id of the student
     */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
     * Used to get the student's first name
     * @return the student's first name
     */
	public String getFirstName() {
		return firstName;
	}
	
	/**
     * Used to set the student's first name
     * @param firstName is the students first name
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
     * Used to get the student's last name
     * @return the student's last name
     */
	public String getLastName() {
		return lastName;
	}
	
	/**
     * Used to set the student's last name
     * @param lastName which is the last name of the student
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
     * Used to get the student's role
     * @return the student's role
     */
	public String getRole() {
		return role;
	}
	
	/**
     * Used to set the student's role
     * @param role of the users if gpc or student
     */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
     * Used to get the student's department of study
     * @return the student's department
     */
	public String getDepartment() {
		return department;
	}
	
	/**
     * Used to set the student's department of study
     * @param department of study 
     */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
     * Constructor to set id, first name, last name, role and department fields
     * @param id is the id of the user
     * @param firstName is the first name of the user
     * @param lastName is the last name of the user
     * @param role determines if they're a gpc or student   
     * @param department or field of study 
     * @return the student's id
     * @throws 
     */
	public User(String id, String firstName, String lastName, String role, String department)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.department = department;
	}
	
	/**
     * A to string method to print all values of the user calss 
     * @return a string of all values for the class
     */
	public String toString()
	{
		return "User [id=" + id + ", firstName=" + firstName + "" + ", lastName=" + lastName + ", role=" + role + ", department=" + department + "" +"]";
	}
}
