package edu.sc.csce740;



public class Term {

	//Class Variables
	private String semester;
	private Integer year;
	
	 /**
     * Constructor for setting the semester and year of the project
     * @param semester which holds values FALL, SUMMER or SPRING
     * @param year the year for the selected term
     */
	public Term(String semester, Integer year) {
		super();
		this.semester = semester;
		this.year = year;
	}
	
	 /**
     * Default constructor that sets the values of semester and year to default values
     */
	public Term() {
		this.semester = "";
		this.year = 0;
	}
	 /**
     * Getter method for the semester
     * @return semester
     */
	public String getSemester() {
		return semester;
	}
	
	 /**
     * Sets the semester string 
     * @param semester value to set the semester 
     */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	 /**
     * Gets the year of the selected term
     * @return year of the selected term
     */
	public Integer getYear() {
		return year;
	}
	
	 /**
     * Loads the list of valid courses.
     * @param coursesFile the filename of the users file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
	public void setYear(Integer year) {
		this.year = year;
	}
	
	 /**
     * To String method to display the data
     * @return a string of for the data in the class
     */
	@Override
	public String toString() {
		return "Term [semester=" + semester + ", year=" + year + "]";
	}
	
	
	
}
