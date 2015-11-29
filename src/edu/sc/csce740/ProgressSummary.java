package edu.sc.csce740;

import java.util.List;

public class ProgressSummary {

	//Class Variables
	private Student student;
	private String department;
	private Term termBegan;
	private Degree degreeSought;
	private Degree certificateSought;
	private List<Professor> advisors;
	private List<Professor> committee;
	private List<RequirementCheckResults> requirementCheckResults;
	
	public ProgressSummary(){
		
	}
	
	/**
     * Constructor that takes a several arguments to build the Progress Summary report
     * @param student is an object of type student
     * @param department is the major of the student
     * @param termBegan is the term the degree was started
     * @param degreeSought is the degree that is being sought
     * @param certificateSought is the certificate that is being sought after
     * @param advisors is the list of professors that will advise the student
     * @param committee is the list of committee members for that student
     * @return 
     * @throws 
     *
     **/
	public ProgressSummary(Student student, String department, Term termBegan, Degree degreeSought,
			Degree certificateSought, List<Professor> advisors, List<Professor> committee,
			List<RequirementCheckResults> requirementCheckResults) {
		super();
		this.student = student;
		this.department = department;
		this.termBegan = termBegan;
		this.degreeSought = degreeSought;
		this.certificateSought = certificateSought;
		this.advisors = advisors;
		this.committee = committee;
		this.requirementCheckResults = requirementCheckResults;
	}

	/**
     * Method to return the student object  
     * @param 
     * @return student 
     * @throws 
     */
	public Student getStudent() {
		return student;
	}
	
	/**
     * Method to set the student object
     * @param student holds relevant info about the student
     * @return 
     * @throws 
     */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	/**
     * Method to return the department value for this class
     * @param 
     * @return department is the major of the student
     * @throws 
     */
	public String getDepartment() {
		return department;
	}
	
	/**
     * Method to set the department of the student 
     * @param department is a string that holds the major 
     * @return 
     * @throws 
     */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
     * Method to return the term the degree was started in 
     * @param 
     * @return termBegan object
     * @throws 
     */
	public Term getTermBegan() {
		return termBegan;
	}
	
	/**
     * Method to set the termBegan object
     * @param termBegan is a Term object
     * @return 
     * @throws 
     */
	public void setTermBegan(Term termBegan) {
		this.termBegan = termBegan;
	}
	
	/**
     * Method to return the degree being sought
     * @param 
     * @return degreeSought is a degree object
     * @throws 
     */
	public Degree getDegreeSought() {
		return degreeSought;
	}
	
	/**
     * Method to set the degree being sought
     * @param degreeSought is a degree object
     * @return 
     * @throws 
     */
	public void setDegreeSought(Degree degreeSought) {
		this.degreeSought = degreeSought;
	}
	
	/**
     * Method to return the certificate being sought after 
     * @param 
     * @return certificateSought is a degree object
     * @throws 
     */
	public Degree getCertificateSought() {
		return certificateSought;
	}
	
	/**
     * Method to set the certificate being sought
     * @param certificateSought is of type degree
     * @return 
     * @throws 
     */
	public void setCertificateSought(Degree certificateSought) {
		this.certificateSought = certificateSought;
	}
	
	/**
     * Method to return the list of advisors for the student
     * @param 
     * @return advisors is a list of professors
     * @throws 
     */
	public List<Professor> getAdvisors() {
		return advisors;
	}
	
	/**
     * Method to set the advisors list
     * @param advisors is a list of professors
     * @return 
     * @throws 
     */
	public void setAdvisors(List<Professor> advisors) {
		this.advisors = advisors;
	}
	
	/**
     * Method to return the list of committee members 
     * @param 
     * @return committee is a list of professors
     * @throws 
     */
	public List<Professor> getCommittee() {
		return committee;
	}
	
	/**
     * Method to set the list of committee members
     * @param committee is a list of professor
     * @return 
     * @throws 
     */
	public void setCommittee(List<Professor> committee) {
		this.committee = committee;
	}
	
	/**
     * Method to return a list of requirement checks 
     * @param 
     * @return requirementCheckResults is a list of requirement check results objects
     * @throws 
     */
	public List<RequirementCheckResults> getRequirementCheckResults() {
		return requirementCheckResults;
	}
	
	/**
     * Method to set the list of requirement checks 
     * @param requirementCheckResults is a list of requirement check results objects
     * @return 
     * @throws 
     */
	public void setRequirementCheckResults(List<RequirementCheckResults> requirementCheckResults) {
		this.requirementCheckResults = requirementCheckResults;
	}
	
	/**
     * Method to set the list of of requirement check results depending on the degree sought and certificate sought
     * @param activeStud is the student record to build the requirement check results from
     * @return 
     * @throws 
     */
	public void setRequirementCheckResults(StudentRecord activeStud){
		if (activeStud.getDegreeSought() != null)
		{
			if(activeStud.getDegreeSought().getName().equals("PHD")){
				System.out.println(activeStud.getStudent().getId() + " is a PHD student!");
				PHD activeDeg = new PHD();
				activeDeg.create_PHD(activeStud);
				this.requirementCheckResults = activeDeg.getpHD();
			}
			if(activeStud.getDegreeSought().getName().equals("MSE")){
				System.out.println(activeStud.getStudent().getId() + " is a MSE student!");
				MSE activeDeg = new MSE();
				activeDeg.create_MSE(activeStud);
				this.requirementCheckResults = activeDeg.getmSE();
			}
			if(activeStud.getDegreeSought().getName().equals("MENG")){
				System.out.println(activeStud.getStudent().getId() + " is a MENG student!");
				MENG activeDeg = new MENG();
				activeDeg.create_MENG(activeStud);
				this.requirementCheckResults = activeDeg.getmENG();
			}
			if(activeStud.getDegreeSought().getName().equals("MS")){
				System.out.println(activeStud.getStudent().getId() + " is a MS student!");
				MS activeDeg = new MS();
				activeDeg.create_MS(activeStud);
				this.requirementCheckResults = activeDeg.getmS();
				
			}
		}
		
		if(activeStud.getCertificateSought() != null &&
		    activeStud.getCertificateSought().getName().equals("INFORMATION_ASSURANCE")){
			System.out.println(activeStud.getStudent().getId() + " is a CGSIAS student!");
			CGSIAS activeDeg = new CGSIAS();
			activeDeg.create_CGSIAS(activeStud);
			this.requirementCheckResults.addAll(activeDeg.getcGSIAS());
		}
	}
	
	/**
     * Method to return the a string of all the private members in the ProgressSummary class
     * @param 
     * @return a string of all private members
     * @throws 
     */
	public String toString() {
		return "ProgressSummary [student=" + student + ", department=" + department + ", termBegan=" + termBegan
				+ ", degreeSought=" + degreeSought + ", certificateSought=" + certificateSought + ", advisors="
				+ advisors + ", committee=" + committee + ", requirementCheckResults=" + requirementCheckResults + "]";
	}

}
