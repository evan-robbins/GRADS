package edu.sc.csce740;

public class CourseTaken {

	private Course course;
	private Term term;
	private char grade;
	
	
    /**
     * Returns a CourseTaken object with course, term, and grade
     * @param 
     * @return a CourseTaken object with course, term, and grade
     * @throws 
     */
	public CourseTaken() 
	{
		this.course = new Course();
		this.term = new Term();
		this.grade = '_';
	}
	
    /**
     * Returns a CourseTaken object with course, term, and grade
     * @param 
     * @return a CourseTaken object with course, term, and grade
     * @throws 
     */
	public CourseTaken(Course course, Term term, char grade)
	{
		this.course = course;
		this.term = term;
		this.grade = grade;
	}
	
    /**
     * Returns the Course course
     * @param 
     * @return the Course course
     * @throws 
     */
	public Course getCourse() {
		return course;
	}

    /**
     * Sets the Course course
     * @param  course sets the value of the course variable
     * @return 
     * @throws 
     */
	public void setCourse(Course course) {
		this.course = course;
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
     * Returns the char grade
     * @param 
     * @return the char grade
     * @throws 
     */
	public char getGrade() {
		return grade;
	}

    /**
     * Sets the char grade
     * @param  grade sets the value of the grade variable
     * @return 
     * @throws 
     */
	public void setGrade(char grade) {
		this.grade = grade;
	}

    /**
     * Returns a string containing the value of all of the class variables
     * @param 
     * @return Returns a string containing the value of all of the class variables
     * @throws 
     */
	public String toString() {
		return "CourseTaken [course=" + course + ", term=" + term + ", grade=" + grade + "]";
	}
	
}
