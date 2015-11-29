package edu.sc.csce740;

public class Degree {

	//Class Variables
	private String name;
	private Term graduation;
	
    /**
     * Returns a Degree object with name and graduation
     * @param 
     * @return a Degree object with name and graduation
     * @throws 
     */
	public Degree(String name, Term graduation) 
	{
		this.name = name;
		this.graduation = graduation;
	}
	
    /**
     * Returns an empty Degree object
     * @param 
     * @return an empty Degree object
     * @throws 
     */
	public Degree() {
		this.name = "defaulDegreeName";
		this.graduation = new Term();
	}

    /**
     * Returns the String name
     * @param 
     * @return the String name
     * @throws 
     */
	public String getName() {
		return name;
	}
	
    /**
     * Sets the String name
     * @param  name sets the value of the name variable
     * @return 
     * @throws 
     */
	public void setName(String name) {
		this.name = name;
	}
	
    /**
     * Returns the Term graduation
     * @param 
     * @return the Term graduation
     * @throws 
     */
	public Term getGraduation() {
		return graduation;
	}
	
    /**
     * Sets the Term graduation
     * @param  graduation sets the value of the graduation variable
     * @return 
     * @throws 
     */
	public void setGraduation(Term graduation) {
		this.graduation = graduation;
	}

    /**
     * Returns a string containing the value of all of the class variables
     * @param 
     * @return Returns a string containing the value of all of the class variables
     * @throws 
     */
	public String toString() {
		return "Degree [name=" + name + ", graduation=" + graduation + "]";
	}
		
}
