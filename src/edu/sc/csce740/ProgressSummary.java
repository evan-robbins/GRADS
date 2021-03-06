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
	
	//General Constructor
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

	//Getters and Setters
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Term getTermBegan() {
		return termBegan;
	}
	public void setTermBegan(Term termBegan) {
		this.termBegan = termBegan;
	}
	public Degree getDegreeSought() {
		return degreeSought;
	}
	public void setDegreeSought(Degree degreeSought) {
		this.degreeSought = degreeSought;
	}
	public Degree getCertificateSought() {
		return certificateSought;
	}
	public void setCertificateSought(Degree certificateSought) {
		this.certificateSought = certificateSought;
	}
	public List<Professor> getAdvisors() {
		return advisors;
	}
	public void setAdvisors(List<Professor> advisors) {
		this.advisors = advisors;
	}
	public List<Professor> getCommittee() {
		return committee;
	}
	public void setCommittee(List<Professor> committee) {
		this.committee = committee;
	}
	public List<RequirementCheckResults> getRequirementCheckResults() {
		return requirementCheckResults;
	}
	public void setRequirementCheckResults(List<RequirementCheckResults> requirementCheckResults) {
		this.requirementCheckResults = requirementCheckResults;
	}

	//General ToString Method
	@Override
	public String toString() {
		return "ProgressSummary [student=" + student + ", department=" + department + ", termBegan=" + termBegan
				+ ", degreeSought=" + degreeSought + ", certificateSought=" + certificateSought + ", advisors="
				+ advisors + ", committee=" + committee + ", requirementCheckResults=" + requirementCheckResults + "]";
	}

}
