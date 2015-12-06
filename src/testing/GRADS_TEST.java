package testing;

import edu.sc.csce740.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.sc.csce740.GRADS;

public class GRADS_TEST {

	GRADS grads = new GRADS();
	
	
	
    /**
     * This test creates a user object with the correct data for student mhunt.
     * It compares the user object to the activeUser of GRADS.
     * @param 
     * @return 
     * @throws 
     */
	@Test
	public void setUserPass() {
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");
		
		//Test Object
		User validUser = new User();
		validUser.setId("mhunt");
		validUser.setFirstName("Michelle");
		validUser.setLastName("Hunt");
		validUser.setRole("STUDENT");
		validUser.setDepartment("COMPUTER_SCIENCE");
		
		//Setting the GRADS user to a valid ID
		grads.setUser("mhunt");

		//Confirming that the active GRADS user data matches the correct values
		assertEquals(grads.getactiveUser_().toString(), validUser.toString());
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}

	
    /**
     * This test puts in a false value into the setUser function.
     * When a false value is put into the setUser function, the activeUser remains null.
     * It checks that the activeUser is null.
     * @param 
     * @return 
     * @throws 
     */
	@Test
	public void setUserFail() {
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		//Setting the GRADS user to an invalid ID
		grads.setUser("fail");
		
		//Confirming that the active GRADS user is null
		assertNull(grads.getactiveUser_());
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * This test creates a String mhunt.
     * It compares the string to the output of the getUser function.
     * @param 
     * @return 
     * @throws 
     */
	@Test
	public void getUserPass() {
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		String validUserID = "mhunt";
		
		grads.setUser("mhunt");
		
		assertEquals(grads.getUser(), validUserID);
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
	
    /**
     * This test puts in a false value into the setUser function.
     * When a false value is put into the setUser function, the activeUser remains null.
     * It checks that the activeUser is null.
     * @param 
     * @return 
     * @throws 
     */
	@Test
	public void getUserFail() {
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("fail");
		
		assertNull(grads.getUser());
		grads.clearSession();
		
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
	
    /**
     * This test creates a list of Strings with the all of the users from the Users database.
     * It compares the list to the output of the getStudentIDs function.
     * @param 
     * @return 
     * @throws 
     */
	@Test
	public void getStudentIDsPass(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		List<String> userIDs = new ArrayList<String>();
		userIDs.add("mhunt");
		userIDs.add("ggay");
		userIDs.add("rbob");
		userIDs.add("rbob2");
		userIDs.add("katek");

		grads.setUser("mmatthews");
		
		//System.out.println(userIDs.toString());
		//System.out.println(grads.getStudentIDs().toString());
		
		assertEquals(grads.getStudentIDs(), userIDs);
		grads.clearSession();
		
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
	
    /**
     * This test puts in a false value into the setUser function.
     * When a false value is put into the setUser function, the activeUser remains null.
     * If the activeUser is null, the output of the getStudentIDs will be null.
     * This test checks that the output of the getStudentIDs function is null.
     */ 
	@Test
	public void getStudentIDsFail(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("fail");
		
		assertEquals(grads.getStudentIDs(), null);
		
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
	
    /**
     * This test creates a Student object, Professor Object, and list of Strings with
     * the correct information from student ggay.
     * It compares the created objects with the object created by the getTranscript function.
     */ 
	@Test
	public void getTransciptPass(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("ggay");
		
		Student testStu = new Student("ggay", "Greg", "Gay");
		Professor testProf = new Professor("COMPUTER_SCIENCE", "Duncan", "BUELL");
		List<String> testNote = new ArrayList<String>();
		testNote.add("note1");
		testNote.add("note2");
		testNote.add("note3");
	
		StudentRecord test = grads.getTranscript("ggay");
		
		assertEquals(test.getStudent().toString(), testStu.toString());
		assertEquals(test.getAdvisors().get(0).toString(), testProf.toString());
		assertEquals(test.getNotes().toString(), testNote.toString());
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * This test puts in a false value into the setUser function.
     * When a false value is put into the setUser function, the activeUser remains null.
     * If the activeUser is null, the output of the getTranscript will be null.
     * This test checks that the output of the getTranscript function is null.
     */ 
	@Test
	public void getTransciptFail(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("fail");
		
		StudentRecord test = grads.getTranscript("fail");
		
		assertEquals(test, null);
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * I had to add a user rbob2 to the Users database and Students database.
     * It checks that rbob2 fails every degree rule of a PHD student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryFailPHD(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("rbob2");
		
		ProgressSummary test = grads.generateProgressSummary("rbob2");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertFalse(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
	
    /**
     * I had to add a user rbob2 to the Users database and Students database.
     * It checks that rbob2 fails every degree rule of a MSE student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryFailMSE(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("rbob2");
		
		StudentRecord studRecTest = grads.getTranscript("rbob2");
		studRecTest.getDegreeSought().setName("MSE");
		grads.updateTranscript("rbob2", studRecTest, false);
		
		ProgressSummary test = grads.generateProgressSummary("rbob2");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertFalse(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
	
    /**
     * I had to add a user rbob2 to the Users database and Students database.
     * It checks that rbob2 fails every degree rule of a MENG student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryFailMENG(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("rbob2");
		
		StudentRecord studRecTest = grads.getTranscript("rbob2");
		studRecTest.getDegreeSought().setName("MENG");
		grads.updateTranscript("rbob2", studRecTest, false);
		
		ProgressSummary test = grads.generateProgressSummary("rbob2");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertFalse(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * I had to add a user rbob2 to the Users database and Students database.
     * It checks that rbob2 fails every degree rule of a MS student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryFailMS(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("rbob2");
		
		StudentRecord studRecTest = grads.getTranscript("rbob2");
		studRecTest.getDegreeSought().setName("MS");
		grads.updateTranscript("rbob2", studRecTest, false);
		
		ProgressSummary test = grads.generateProgressSummary("rbob2");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertFalse(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
	
    /**
     * I had to add a user rbob2 to the Users database and Students database.
     * It checks that rbob2 fails every degree rule of a INFAS student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryFailINFAS(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("rbob2");
		
		StudentRecord studRecTest = grads.getTranscript("rbob2");
		studRecTest.getDegreeSought().setName("cert");
		grads.updateTranscript("rbob2", studRecTest, false);
		
		ProgressSummary test = grads.generateProgressSummary("rbob2");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertFalse(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * I had to add a user katek to the Users database and Students database.
     * It checks that katek passes every degree rule of a INFAS student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryPassPHD(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("katek");
		
		ProgressSummary test = grads.generateProgressSummary("katek");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertTrue(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * I had to add a user katek to the Users database and Students database.
     * It checks that katek passes every degree rule of a INFAS student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryPassMSE(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("katek");
		
		StudentRecord studRecTest = grads.getTranscript("katek");
		studRecTest.getDegreeSought().setName("MSE");
		grads.updateTranscript("katek", studRecTest, false);
		
		ProgressSummary test = grads.generateProgressSummary("katek");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertTrue(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * I had to add a user katek to the Users database and Students database.
     * It checks that katek passes every degree rule of a INFAS student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryPassMENG(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("katek");
		
		StudentRecord studRecTest = grads.getTranscript("katek");
		studRecTest.getDegreeSought().setName("MENG");
		grads.updateTranscript("katek", studRecTest, false);
		
		ProgressSummary test = grads.generateProgressSummary("katek");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertTrue(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * I had to add a user katek to the Users database and Students database.
     * It checks that katek passes every degree rule of a INFAS student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryPassMS(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("katek");
		
		StudentRecord studRecTest = grads.getTranscript("katek");
		studRecTest.getDegreeSought().setName("MS");
		grads.updateTranscript("katek", studRecTest, false);
		
		ProgressSummary test = grads.generateProgressSummary("katek");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertTrue(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
    /**
     * I had to add a user katek to the Users database and Students database.
     * It checks that katek passes every degree rule of a INFAS student.
     * It checks the passed variable of every requirementCheckResult object returned from the generateProgressSummary function.
     */ 
	@Test
	public void generateProgressSummaryPassINFAS(){
		try
		{
		//The GRADS system is loading the users, courses, and students databases.
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/resources/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/resources/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/resources/students.txt");

		grads.setUser("katek");
		
		StudentRecord studRecTest = grads.getTranscript("katek");
		studRecTest.getDegreeSought().setName("cert");
		grads.updateTranscript("katek", studRecTest, false);
		
		ProgressSummary test = grads.generateProgressSummary("katek");
		
		for(int index=0; index<test.getRequirementCheckResults().size(); index++){
			assertTrue(test.getRequirementCheckResults().get(index).getPassed());
		}
		
		grads.clearSession();
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
	}
	
	
	/**
	 * PassClearSession checks to see if the current session data was clear. If the user is still logged in
	 * or the user is able to use any grads functionality, then this test should fail. If a grads 
	 * method is suppsoe to return an object, then null is returned. If a grads method is void, then a boolean 
	 * for that method will be set to true to let us know that the function failed.
	 */
	@Test
	public void PassClearSession() {
		
		try 
		{
			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");	 
			
			//set the user
			grads.setUser("mmatthews");
			grads.clearSession();
			
			StudentRecord rec = new StudentRecord();
			List<CourseTaken> courses = new ArrayList<CourseTaken>();
			
			//attempt to update the transcript
			grads.updateTranscript("kate", rec, false);
			//attempt to add a note
			grads.addNote("tim", "stere", false);
			
			//check that no student ids were returned
			if(grads.getStudentIDs() == null &&
			   grads.getTranscript("katek") == null &&
			   grads.getUpdateTranscriptFailed() == true &&
			   grads.getAddNoteFailed() == true && 
			   grads.generateProgressSummary("kitty") == null &&
			   grads.simulateCourses("kitty", courses) == null)
			{
				
				assert(true);
			}
			else
			{
				assert(false);
			}
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	
	/**
	 * PassAddNote is the happy path test case for adding a note. It asserts true if 
	 * the function worked as intended.
	 */
	@Test
	public void PassAddNote(){
		
		try{
			
			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");	 
			
			//set the user to a gpc
			grads.setUser("mmatthews");
			
			//add note to  kateks student record
			grads.addNote("katek", "Bazinga", false);
			
			//get her student record
			StudentRecord rec = grads.getTranscript("katek");
			
			//loop over kates record to see if the note was added 
			for (int index = 0; index < rec.getNotes().size(); index++)
			{
				if (rec.getNotes().get(index).equals("Bazinga"))
				{
					assert(true);
					break;
				}
				else if (rec.getNotes().size() == index)
				{
					assert(false);
				}
			}
			
		} catch(Exception e) {
			
			assert(false);
		}
	}
	
	/**
	 * The unhappy path for the FailAddNote asserts true if the method was 
	 * not able to add the note to the student record.
	 * 
	 */
	@Test
	public void FailAddNote(){
		
		try{
			
			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");	 
			
			//set the user to a gpc
			grads.setUser("mmatthews");
			
			//add note to  kateks student record
			grads.addNote("kittyKat", "Bazinga", false);
			
			//get her student record
			StudentRecord rec = grads.getTranscript("katek");
			
			//loop over kates recrod to see if the note was added 
			for (int index = 0; index < rec.getNotes().size(); index++)
			{
				if (rec.getNotes().get(index).equals("Bazinga"))
				{
					assert(false);
					break;
				}
				else if (rec.getNotes().size() == index)
				{
					assert(true);
				}
			}
			
		} catch(Exception e) {
			
			assert(false);
		}
	}
	
	/**
	 * The happy path case for simulate course will assert true if the list of simulated courses
	 * was successful.
	 */
	@Test
	public void PassSimulateCourses()
	{
		try{
			
			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");	 
			
			//set the user to a gpc
			grads.setUser("mmatthews");
			
			//courses - set them to be empty
			//List<CourseTaken> courses = grads.getTranscript("ggay").getCoursesTaken();
			
			List<CourseTaken> courses = new ArrayList<CourseTaken>(1);
			
			//create a sinlge course to add to his list
			Course course = new Course();
			course.setName("Software Engineering");
			course.setId("csce740");
			course.setNumCredits("3");
						
			Term tempTerm = new Term("FALL",2015);		
			CourseTaken tempCourse = new CourseTaken(course, tempTerm,'A');
			courses.add(0,tempCourse);
			
			//mhunt should have an empty list of courses
			if (grads.simulateCourses("mhunt", courses) != null)
			{
				StudentRecord rec = grads.getTranscript("mhunt");
				System.out.println(rec.getCoursesTaken().size());
				int counter = 0;
				for (int index = 0; index < rec.getCoursesTaken().size(); index++)		
				{
					if (rec.getCoursesTaken().get(index).getCourse().getId().equals("csce740") &&
						rec.getCoursesTaken().get(index).getCourse().getName().equals("Software Engineering") &&
						rec.getCoursesTaken().get(index).getCourse().getNumCredits().equals("3") &&
						rec.getCoursesTaken().get(index).getTerm().getSemester().equals("FALL") &&
						rec.getCoursesTaken().get(index).getTerm().getYear() == 2015 &&
						rec.getCoursesTaken().get(index).getGrade() == 'A')
					{
						//assert(true);
						counter++;
					}
				}
				
				if(counter == 1)
				{
					assert(true);
				}
				else
				{
					assert(false);
				}										
			}
			else
			{
				assert(false);
			}
							
		} catch(Exception e) {
			
			assert(false);
		}
	}
	
	/**
	 * The sad path case for simulate course will assert true if the list of simulated courses
	 * was unsuccessful.
	 */
	@Test
	public void FailSimulateCourses()
	{
		try{
			
			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");	 
			
			//set the user to a gpc
			grads.setUser("mmatthews");
			
			List<CourseTaken> courses = new ArrayList<CourseTaken>();
			
			if (grads.simulateCourses("kittyKate", courses) == null)
			{
				assert(true);
			}
			else
			{
				assert(false);
			}
			
		} catch(Exception e) {
			
			assert(false);
		}
	}
	
	/**
	 * The happy path test case will assert true if update transcript was successful
	 */
	@Test
	public void PassUpdateTransciprt(){
		
		try{
			
			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");	
			
			grads.setUser("katek");
			
			//change the first name of the record
			StudentRecord rec = grads.getTranscript("katek");
			rec.getStudent().setFirstName("pikachu");
			
			grads.updateTranscript("katek", rec, false);
			
			//check to see if the first name was changed
			if (grads.getUpdateTranscriptFailed() == false)
			{
				for (int index = 0; index < grads.getTemporaryRecords().size(); index++ )
				{
					if(grads.getTemporaryRecords().get(index).getStudent().getId().equals("katek") && 
					   grads.getTemporaryRecords().get(index).getStudent().getFirstName().equals("pikachu"))
					{
						assert(true);
						break;
					}
					
					else if (grads.getTemporaryRecords().size() == index)
					{
						assert(false);
					}
				}
			}
			else
			{
				assert(false);
			}
		}
	   catch(Exception e) {
		
		assert(false);
	   }
	}
	
	/**
	 * The sad path test case will assert true if update transcript was unsuccessful
	 * for any reason.
	 */
	@Test
	public void FailUpdateTransciprt(){
		
		try{
		
			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");	
			
			grads.setUser("mhunt");
			
			StudentRecord rec = grads.getTranscript("mhunt");
			
			Term tempTerm = new Term("FALL", 2012);
			Degree degree = new Degree("bleh", tempTerm);
			rec.setDegreeSought(degree);
			
			grads.updateTranscript("mhunt", rec, false);
			
			if (grads.getUpdateTranscriptFailed() == false &&
				grads.getTranscript("mhunt").getStudent().getFirstName().equals("piakchu"))
			{
				assert(true);
			}
			else
			{
				assert(false);
			}
		}
	   catch(Exception e) {
		
		assert(false);
	   }
	}


	
	
	
	
}
