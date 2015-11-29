package edu.sc.csce740;

public class Milestone {
	
	//Class Variables
	private String milestone;
	private Term term;
	
    /**
     * Returns a Milestone object with milestone and graduation
     * @param 
     * @return a Milestone object with milestone and graduation
     * @throws 
     */
	public Milestone(String milestone, Term term) {
		super();
		this.milestone = milestone;
		this.term = term;
	}
	
    /**
     * Returns an empty Milestone object
     * @param 
     * @return an empty Milestone object
     * @throws 
     */
	public Milestone() 
	{
		this.milestone = "defaultMilestone";
		this.term = new Term();
	}

    /**
     * Returns the String milestone
     * @param 
     * @return the String milestone
     * @throws 
     */
	public String getMilestone() {
		return milestone;
	}
	
    /**
     * Sets the String milestone
     * @param  milestone sets the value of the milestone variable
     * @return 
     * @throws 
     */
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	
	 /**
     * Returns the Term term
     * @param 
     * @return the Term term
     * @throws 
     */
	public Term getTerm() {
		return term;
	}
	
    /**
     * Sets the Term term
     * @param  term sets the value of the term variable
     * @return 
     * @throws 
     */
	public void setTerm(Term term) {
		this.term = term;
	}
	
    /**
     * Returns a string containing the value of all of the class variables
     * @param 
     * @return Returns a string containing the value of all of the class variables
     * @throws 
     */
	public String toString() {
		return "Milestone [milestone=" + milestone + ", term=" + term + "]";
	}	
	
}
