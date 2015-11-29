
package edu.sc.csce740;

public class Course {

	//Class Variables
	private String name;
	private String id;
	private String numCredits;
	
    /**
     * Returns an empty Course object
     * @param 
     * @return an empty Course object
     * @throws 
     */
	public Course(){
		name = "";
		id = "";
		numCredits = "";
	}
	
    /**
     * Returns the String name
     * @param 
     * @return Returns the String name
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
     * Returns the String id
     * @param 
     * @return Returns the String id
     * @throws 
     */
	public String getId() {
		return id;
	}

    /**
     * Sets the String name
     * @param  id sets the value of the id variable
     * @return 
     * @throws 
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * Returns the String numCredits
     * @param 
     * @return Returns the String numCredits
     * @throws 
     */
	public String getNumCredits() {
		return numCredits;
	}

    /**
     * Sets the String numCredits
     * @param  numCredits sets the value of the numCredits variable
     * @return 
     * @throws 
     */
	public void setNumCredits(String numCredits) {
		this.numCredits = numCredits;
	}
	
    /**
     * Returns a string containing the value of all of the class variables
     * @param 
     * @return Returns a string containing the value of all of the class variables
     * @throws 
     */
	public String toString()
	{
		return "Courses [name=" + name + "" + ", id=" + id + ", numCredits=" + numCredits +"]";
	}
}

