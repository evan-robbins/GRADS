package edu.sc.csce740;

public class RequirementCheckResults {
	
	//Class Variables
	private String name;
	private Boolean passed;
	private Details details;
	
	/**
     * Constructor for a requirement check that takes a string, a boolean and a details object
     * @param name is the name of the requirement being checked 
     * @param passed determines if the requirement has passed 
     * @param details a details object containing other relevant information about the requirement
     * @return 
     * @throws 
     */
	public RequirementCheckResults(String name, Boolean passed, Details details) {
		super();
		this.name = name;
		this.passed = passed;
		this.details = details;
	}

	/**
     * Method to return the requirement's name 
     * @param 
     * @return name of the requirement
     * @throws 
     */
	public String getName() {
		return name;
	}
	
	/**
     * Method to set the name of the requirement
     * @param name is a string object
     * @return 
     * @throws 
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Method to return passed status of the requirement
     * @param 
     * @return passed is of type boolean
     * @throws 
     */
	public Boolean getPassed() {
		return passed;
	}
	
	/**
     * Method to set the passed status of the requirement
     * @param passed is of type boolean
     * @return 
     * @throws 
     */
	public void setPassed(Boolean passed) {
		this.passed = passed;
	}
	
	/**
     * Method to return the details object of the requirement
     * @param 
     * @return details object
     * @throws 
     */
	public Details getDetails() {
		return details;
	}
	
	/**
     * Method to set the details object for a requirement
     * @param details object
     * @return 
     * @throws 
     */
	public void setDetails(Details details) {
		this.details = details;
	}

	/**
     * Method to return the a string of all the private members in the requirement class
     * @param 
     * @return a string composed of the name, passed status  and details of a requirement
     * @throws 
     */
	public String toString() {
		return "RequirementCheckResults [name=" + name + ", passed=" + passed + ", details=" + details + "]";
	}	
	
}
