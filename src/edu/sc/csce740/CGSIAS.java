
package edu.sc.csce740;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CGSIAS {

	//Class Variables
	private List<RequirementCheckResults> cGSIAS = new ArrayList<RequirementCheckResults>();

    /**
     * Returns the requirement Check results for the certificate
     * @param cGSIAS sets the value of the requirementCheckResults list
     * @return a CGSIAS object with the value of cGSIAS
     * @throws 
     */
	public CGSIAS(List<RequirementCheckResults> cGSIAS) {
		super();
		this.cGSIAS = cGSIAS;
	}
    
	/**
     * Returns an empty CGSIAS object
     * @param 
     * @return empty CGSIAS object
     * @throws 
     */
	public CGSIAS(){
		
	}

	
    /**
     * Returns the requirement Check results for the certificate
     * @param 
     * @return Returns the requirement Check results for the certificate
     * @throws 
     */
	public List<RequirementCheckResults> getcGSIAS() {
		return cGSIAS;
	}
	
    /**
     * Sets the requirement Check results for the certificate
     * @param  cGSIAS sets the value of the requirement check results
     * @return 
     * @throws 
     */
	public void setcGSIAS(List<RequirementCheckResults> cGSIAS) {
		this.cGSIAS = cGSIAS;
	}
	
    /**
     * Creates the progress report for the certificate 
     * @param studRec is a student record to be passed in
     * @return 
     * @throws 
     */
	public void create_CGSIAS(StudentRecord studRec){
		core_courses_infas(studRec.getCoursesTaken());
		additional_credits_infas(studRec);
		time_limit_infas(studRec.getTermBegan().getYear());
		gpa(studRec.getCoursesTaken());
	}
	
    /**
     * Checks to see if the core courses are passed for the security certificate
     * @param Courses is a list of courses taken by the student
     * @return 
     * @throws 
     */
	public void core_courses_infas(List<CourseTaken> courses){
		//Function Variables
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		boolean passed = false;
		int passedVal = 0;
		boolean [] coursePassed = new boolean[3];
		Arrays.fill(coursePassed, Boolean.FALSE);

		String [] courseNames = new String[3];
		courseNames[0] = "csce522";
		courseNames[1] = "csce715";
		courseNames[2] = "csce727";
		
		//Uses Course Taken Object to compute CORE_COURSES_MENG rule
		for(int index=0; index<courses.size(); index++){
			for(int i=0; i<courseNames.length; i++){
				if(courses.get(index) != null && 
				   courses.get(index).getCourse().getId().equals(courseNames[i])){
					if(courses.get(index).getGrade() == 'A' || courses.get(index).getGrade() == 'B'){
						if(year - courses.get(index).getTerm().getYear() < 6){
						core_course_list.add(courses.get(index));
						passedVal++;
						coursePassed[i] = true;
						}
					}
				}
				
			}
		}
		
		for(int i=0; i<courseNames.length; i++){
			if(!coursePassed[i]){
				core_course_notes.add("You have not passed " + courseNames[i]);
			}
		}
		
		if(passedVal == 3){
			passed = true;
		}
		
		
		Details core_details = new Details(null, core_course_list, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("CORE_COURSES_INFAS", passed, core_details);
		this.cGSIAS.add(core_courses);
	}
	
    /**
     * Checks to see if the additional credits milestone has been passed
     * @param studRec is a student record to be passed in
     * @return 
     * @throws 
     */
	public void additional_credits_infas(StudentRecord studRec){
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		boolean passed = false;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int totalHoursCSCE = 0;
		int totalHoursCSCESeven = 0;
		int totalHoursnonCSCE = 0;
		
		
		for(int index=0; index<studRec.getCoursesTaken().size(); index++){
			if(studRec.getCoursesTaken().get(index) != null && year - studRec.getCoursesTaken().get(index).getTerm().getYear() < 6){
				if(studRec.getCoursesTaken().get(index).getGrade() == 'A' || 
				   studRec.getCoursesTaken().get(index).getGrade() == 'B' ){
					if(studRec.getCoursesTaken().get(index).getCourse().getName().equals("csce522") ||
					   studRec.getCoursesTaken().get(index).getCourse().getName().equals("csce715") ||
					   studRec.getCoursesTaken().get(index).getCourse().getName().equals("csce799") ||
					   studRec.getCoursesTaken().get(index).getCourse().getName().equals("csce727") ){
					}else {
							if (studRec.getCoursesTaken().get(index).getCourse().getId().contains("csce") &&
								Integer.parseInt(studRec.getCoursesTaken().get(index).getCourse().getId().substring(studRec.getCoursesTaken().get(index).getCourse().getId().length() -3)) >= 500 &&
								Integer.parseInt(studRec.getCoursesTaken().get(index).getCourse().getId().substring(studRec.getCoursesTaken().get(index).getCourse().getId().length() -3)) < 700 ){
									String hours = studRec.getCoursesTaken().get(index).getCourse().getNumCredits();
									totalHoursCSCE = totalHoursCSCE + Integer.valueOf(hours);
									core_course_list.add(studRec.getCoursesTaken().get(index));
							}
							if (studRec.getCoursesTaken().get(index).getCourse().getId().contains("csce") &&
									Integer.parseInt(studRec.getCoursesTaken().get(index).getCourse().getId().substring(studRec.getCoursesTaken().get(index).getCourse().getId().length() -3)) >= 700){
										String hours = studRec.getCoursesTaken().get(index).getCourse().getNumCredits();
										totalHoursCSCESeven = totalHoursCSCESeven + Integer.valueOf(hours);
										core_course_list.add(studRec.getCoursesTaken().get(index));
							}
							if (!studRec.getCoursesTaken().get(index).getCourse().getId().contains("csce") &&
								Integer.parseInt(studRec.getCoursesTaken().get(index).getCourse().getId().substring(studRec.getCoursesTaken().get(index).getCourse().getId().length() -3)) >= 500){
									String hours = studRec.getCoursesTaken().get(index).getCourse().getNumCredits();
									totalHoursnonCSCE = totalHoursnonCSCE + Integer.valueOf(hours);
									core_course_list.add(studRec.getCoursesTaken().get(index));
							}			
					}
				}
				
			}
		}
				
			if(totalHoursnonCSCE > 6){
				totalHoursnonCSCE = 6;
			}
			
			if(totalHoursCSCE + totalHoursnonCSCE + totalHoursCSCESeven >= 18){
				passed = true;
			} else {
				int remain = 18 - (totalHoursCSCE + totalHoursnonCSCE + totalHoursCSCESeven);
				String failed = "You must pass " + remain + " more hours of graduate courses.";
				core_course_notes.add(failed);
			}
			
			if(totalHoursCSCESeven < 9){
				passed = false;
				String failed = "You must pass atleast 9 hours of CSCE courses numbered 700 or greater.";
				core_course_notes.add(failed);
			}
		
		Details core_details = new Details(null, core_course_list, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("ADDITIONAL_CREDITS_INFAS", passed, core_details);
		this.cGSIAS.add(core_courses);
	}
	
    /**
     * Checks to see if the time limit milestone was complete by the student
     * @param year to see if all courses have been taken within 6 years 
     * @return 
     * @throws 
     */
	public void time_limit_infas(int year){
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		boolean passed = false;
		List<String> core_course_notes = new ArrayList<String>();
		
		if(currentYear - year < 7){
			passed = true;
		}
		
		if(!passed){
			core_course_notes.add("It has been six years since you have been admitted.");
		}
		
		Details core_details = new Details(null, null, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("TIME_LIMIT_INFAS", passed, core_details);
		this.cGSIAS.add(core_courses);
	}
	
    /**
     * Calculates the overall gpa for the certificate
     * @param courses to calculate the gpa for the selected certificate
     * @return 
     * @throws 
     */
	public void gpa(List<CourseTaken> courses){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<Integer> grades = new ArrayList<Integer>();
		int hoursTotal = 0;
		int classGrade = 0;
		double totalGPA = 0;
		String totalGPAString = "";
		boolean passed = false;
		List<String> core_course_notes = new ArrayList<String>();
		
		for(int index=0; index<courses.size(); index++){
			if(courses.get(index) != null &&
			   year - courses.get(index).getTerm().getYear() < 6){
				if(courses.get(index).getGrade() != 'P'){
					if(courses.get(index).getGrade() != '_'){
						classGrade = gpa(courses.get(index).getGrade(),courses.get(index).getCourse().getNumCredits());
						grades.add(classGrade);
						int hoursVal = Integer.valueOf(courses.get(index).getCourse().getNumCredits());
						hoursTotal = hoursTotal + hoursVal;
					}
				}
			}
		}
		
		for(int i=0; i<grades.size(); i++){
			totalGPA = totalGPA + grades.get(i);
		}
		
		totalGPA = totalGPA / (double) hoursTotal;
		BigDecimal bd = new BigDecimal(totalGPA);
		bd = bd.round(new MathContext(3));
		double rounded = bd.doubleValue();
		totalGPAString = Double.toString(rounded);
		
		if(rounded >= 3.00){
			passed = true;
		}
		
		if(!passed){
			core_course_notes.add("Your GPA must be 3.00 or higher.");
		}
		
		Details core_details = new Details(totalGPAString, null, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("GPA", passed, core_details);
		this.cGSIAS.add(core_courses);
	}
	
    /**
     * Calculates the gpa for the number of hours and grade.
     * @param iGgade is the grade made on the course
     * @param iHours the number of hours the course was worth
     * @return the gap for the selected course
     * @throws 
     */
	public int gpa(char iGrade, String iHours){
		int gpa = 0;
		int hours = Integer.valueOf(iHours);
		
		char[] grade = new char[5];
		grade[0] = 'F';
		grade[1] = 'D';
		grade[2] = 'C';
		grade[3] = 'B';
		grade[4] = 'A';
				
		for(int i=4; i>0; i--){
			if(iGrade == grade[i]){
				gpa = i*hours;
			}
		}
		
		
		return gpa;
	}
}

