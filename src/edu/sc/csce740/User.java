package edu.sc.csce740;


public class User {

	private String id;
	private String firstName;
	private String lastName;
	private String role;
	private String department;
	
	public User ()
	{
		id = "";
		firstName = "";
		lastName = "";
		role = "";
		department = "";
	}
	
	public User(String id, String firstName, String lastName, String role, String department)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.department = department;
	}
	
	public String toString()
	{
		return "User [id=" + id + ", firstName=" + firstName + "" + ", lastName=" + lastName + ", role=" + role + ", department=" + department + "" +"]";
	}
}
