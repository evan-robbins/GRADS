package edu.sc.csce740;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GRADS implements GRADSIntf 
{
	private List<User> users;
	private List<Course> courses;
	private List<StudentRecord> records;
	private List<StudentRecord> temporaryRecords; //if the user makes a temp change and then a perma change, perma changes will be added 
	
	private String usersFilePath_ = "";
	private String coursesFilePath_ = "";
	private String recordFilePath_ = "";
	
	private User activeUser_; //this keeps track of the id of the user
	
	public void loadUsers(String usersFile) throws Exception 
	{			
		usersFilePath_ = usersFile;
		
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (usersFile));
		
		users = gson.fromJson(br, new TypeToken <List<User>>(){}.getType());
		br.close();
		System.out.println(this.users);
	}

	
	public void loadCourses(String coursesFile) throws Exception 
	{
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (coursesFile));
		
		this.courses = gson.fromJson(br, new TypeToken <List<Course>>(){}.getType());
		System.out.println(this.courses);
		br.close();
	}

	
	public void loadRecords(String recordsFile) throws Exception 
	{
		recordFilePath_ = recordsFile;
		
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (recordsFile));
		this.records = gson.fromJson(br, new TypeToken <List<StudentRecord>>(){}.getType());
		br.close();
		
		br = new BufferedReader(new FileReader (recordsFile));
		this.temporaryRecords = gson.fromJson(br, new TypeToken <List<StudentRecord>>(){}.getType());
		br.close();	
	}

	
	public void setUser(String userId) throws Exception 
	{
		boolean validUser = false;
		
		for(int index=0; index < users.size(); index++)
		{
			if(userId.equals(users.get(index).getId()))
			{
				if(users.get(index).getDepartment().equals("COMPUTER_SCIENCE")){
					validUser = true;
					activeUser_ = users.get(index);
					System.out.println(users.get(index).getId() + " has access to GRADS");
				} else {
					validUser = true;
					System.out.println("Invalid Major");
				}
				
			}
		}
		
		if(!validUser){
			System.out.println("Invalid UserID");
		}
	}

	//this needs to reload users, courses and records. aslso needs to set the current user to null. 
	public void clearSession() throws Exception {
		
//		String temp = "Invalid User";
//		activeUser_.setId(temp);
//		activeUser_.setFirstName(temp);
//		activeUser_.setLastName(temp);
//		activeUser_.setRole(temp);
//		activeUser_.setDepartment(temp);
		
		this.activeUser_ = null;
		
		loadUsers(usersFilePath_);
		loadCourses(coursesFilePath_);
		loadRecords(recordFilePath_);
		
	}

	
	public List<String> getStudentIDs() throws Exception {
		
		List<String> studentIds = new ArrayList<String>();
		
		for (int index = 0; index < users.size(); index++)
		{
			if (users.get(index).getRole().equals("STUDENT"))
				studentIds.add(users.get(index).getId());
		}
		
		return studentIds;
	}

	
	public StudentRecord getTranscript(String userId) throws Exception {
		
		StudentRecord stuRec = new StudentRecord();
		User inputUser = new User();
		
		boolean validUser = false;
		for(int index=0; index < users.size(); index++)
		{
			if(userId.equals(users.get(index).getId()))
			{
					validUser = true;
					inputUser = users.get(index);
			}
		}
		
		if(!validUser){
			System.out.println(userId + " is an invalid userID");
		}
		
		//Student is requesting their own SR
		if(activeUser_.getId().equals(inputUser.getId())&&activeUser_.getRole().equals("STUDENT")){
			System.out.println(activeUser_.getId() + " is requesting their Student Record.");
			for(int index=0; index < records.size(); index++)
			{
				if(userId.equals(records.get(index).getStudent().getId()))
				{
					stuRec = records.get(index);
				}
			}	
		}
	
		//CS GPC is requesting one of their CS student's SR
		if(!activeUser_.getId().equals(inputUser.getId())&&activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")&&activeUser_.getDepartment().equals(inputUser.getDepartment())){
			System.out.println("GPC " + activeUser_.getId() + " is requesting " + inputUser.getId() + "'s Student Record.");
			for(int index=0; index < records.size(); index++)
			{
				if(userId.equals(records.get(index).getStudent().getId()))
				{
					stuRec = records.get(index);
				}
			}
		}
		return stuRec;
	}

	
	public void updateTranscript(String userId, StudentRecord transcript, Boolean permanent) throws Exception {
		
		
		if (activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")) // check if the user is a gpc
		{
			//is this a permanent change or temp change?
			if (permanent)
			{
				updatePermanentTranscriptGPC(userId, transcript);
			}
			else
			{
				updateTemporaryTranscriptGPC(userId, transcript);
			}
		}
		else //user is a student
		{
			if (activeUser_.getId().equals(userId))
			{
				if (permanent)
				{
					updatePermanentTranscript(userId, transcript);
				}
				else
				{
					updateTemporaryTranscript(userId, transcript);
				}	
			}
			else
			{
				System.out.println("Invalid attempt to access another student's student record");
			}
		}
	}


	private void updatePermanentTranscriptGPC(String userId, StudentRecord transcript) throws Exception {
		
		int recordIndex = -1;
		boolean update = true;
		
		//find the student record
		for (int index = 0; index < records.size(); index++) //find the record 
		{
			if(records.get(index) != null &&
			   records.get(index).getStudent().getId().equals(userId))
			{
				recordIndex = index;
				break;
			}
			else if (index == records.size())
				System.out.println("Student Record doesn't exist");
		}
		
		if (recordIndex != -1)
		{
			//now check that only degree sought, term began, first name, last name, advisors or committee member values were changed
			StudentRecord rec = records.get(recordIndex);
			
			if(rec.getStudent().getId().equals(transcript.getStudent().getId()) &&
			   rec.getDepartment().equals(transcript.getDepartment()) && 
			   rec.getCertificateSought().getName().equals(transcript.getCertificateSought().getName()) &&
			   rec.getCertificateSought().getGraduation().getSemester().equals(transcript.getCertificateSought().getGraduation().getSemester()) &&
			   rec.getCertificateSought().getGraduation().getYear().intValue() == transcript.getCertificateSought().getGraduation().getYear().intValue())
			{
				if (rec.getPreviousDegrees().size() == transcript.getPreviousDegrees().size())
				{
					//previous degrees check 
					for (int index = 0; index < rec.getPreviousDegrees().size(); index++)
					{
						
						if (!rec.getPreviousDegrees().get(index).getName().equals(transcript.getPreviousDegrees().get(index).getName()) &&
							!rec.getPreviousDegrees().get(index).getGraduation().getSemester().equals(transcript.getPreviousDegrees().get(index).getGraduation().getSemester()) &&
							rec.getPreviousDegrees().get(index).getGraduation().getYear().intValue() != transcript.getPreviousDegrees().get(index).getGraduation().getYear().intValue())
						{
							update = false;
						}
					}
				}	
				
				if (update)
				{
					records.add(recordIndex, transcript);
					
					String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(records);
					
					PrintWriter file = new PrintWriter(recordFilePath_);
					file.write("");
					file.append(recordsInJsonFormat);
					file.close();
					
					//update the users information 
					for (int index = 0; index < users.size(); index++)
					{
						if (users.get(index).getId().equals(userId))
						{
							users.get(index).setFirstName(records.get(recordIndex).getStudent().getFirstName());
							users.get(index).setLastName(records.get(recordIndex).getStudent().getLastName());
							break;
						}
					}
					
					String usersInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(users);
					
					file = new PrintWriter(usersFilePath_);
					file.write("");
					file.append(usersInJsonFormat);
					file.close();
					
					System.out.println("Temp field changed");
				}
				else
				{
					System.out.println("Invalid temporary change to a field");
				}
			}
			else 
			{
				System.out.println("Invalid temporary change to a field");
			}
		}
		else // add the student record to the temporary list if it doesn't exist
		{
			records.add(transcript);
		
			String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(records);
			
			PrintWriter file = new PrintWriter(recordFilePath_);
			file.write("");
			file.append(recordsInJsonFormat);
			file.close();
			
			//update the users information 
			for (int index = 0; index < users.size(); index++)
			{
				if (users.get(index).getId().equals(userId))
				{
					users.get(index).setFirstName(records.get(recordIndex).getStudent().getFirstName());
					users.get(index).setLastName(records.get(recordIndex).getStudent().getLastName());
				}
			}
			
			String usersInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(users);
			
			file = new PrintWriter(usersFilePath_);
			file.write("");
			file.append(usersInJsonFormat);
			file.close();
			
			System.out.println("Temp field changed");
		}
	}


	private void updateTemporaryTranscriptGPC(String userId, StudentRecord transcript) {
		
		int recordIndex = -1;
		boolean update = true;
		
		//find the student record
		for (int index = 0; index < temporaryRecords.size(); index++) //find the record 
		{
			if(temporaryRecords.get(index) != null &&
			   temporaryRecords.get(index).getStudent().getId().equals(userId))
			{
				recordIndex = index;
				break;
			}
			else if (index == temporaryRecords.size())
				System.out.println("Student Record doesn't exist");
		}
		
		if (recordIndex != -1)
		{
			//now check that only degree sought, term began, first name, last name, advisors or committee member values were changed
			StudentRecord rec = temporaryRecords.get(recordIndex);
			
			if(rec.getStudent().getId().equals(transcript.getStudent().getId()) &&
			   rec.getDepartment().equals(transcript.getDepartment()) && 
			   rec.getCertificateSought().getName().equals(transcript.getCertificateSought().getName()) &&
			   rec.getCertificateSought().getGraduation().getSemester().equals(transcript.getCertificateSought().getGraduation().getSemester()) &&
			   rec.getCertificateSought().getGraduation().getYear().intValue() == transcript.getCertificateSought().getGraduation().getYear().intValue())
			{
				if (rec.getPreviousDegrees().size() == transcript.getPreviousDegrees().size())
				{
					//previous degrees check 
					for (int index = 0; index < rec.getPreviousDegrees().size(); index++)
					{
						
						if (!rec.getPreviousDegrees().get(index).getName().equals(transcript.getPreviousDegrees().get(index).getName()) &&
							!rec.getPreviousDegrees().get(index).getGraduation().getSemester().equals(transcript.getPreviousDegrees().get(index).getGraduation().getSemester()) &&
							rec.getPreviousDegrees().get(index).getGraduation().getYear().intValue() != transcript.getPreviousDegrees().get(index).getGraduation().getYear().intValue())
						{
							update = false;
						}
					}
				}	
				
				if (update)
				{
					temporaryRecords.add(recordIndex, transcript);
					System.out.println("Temp field changed");
				}
				else
				{
					System.out.println("Invalid temporary change to a field");
				}
			}
			else 
			{
				System.out.println("Invalid temporary change to a field");
			}
		}
		else // add the student record to the temporary list if it doesn't exist
		{
			temporaryRecords.add(transcript);
			System.out.println("Added Temp Student Record");
		}
	}


	private void updatePermanentTranscript(String userId, StudentRecord transcript) throws Exception {
		
		int recordIndex = -1;
		boolean update = true;
		
		//find the student record
		for (int index = 0; index < records.size(); index++) //find the record 
		{
			if(records.get(index) != null &&
			   records.get(index).getStudent().getId().equals(userId))
			{
				recordIndex = index;
				break;
			}
			else if (index == records.size())
				System.out.println("Student Record doesn't exist");
		}
		
		if (recordIndex != -1)
		{
			StudentRecord rec = records.get(recordIndex);
			
			if(rec.getStudent().getId().equals(transcript.getStudent().getId()) &&
			   rec.getDepartment().equals(transcript.getDepartment()) && 
			   rec.getDegreeSought().getName().equals(transcript.getDegreeSought().getName()) &&
			   rec.getDegreeSought().getGraduation().getSemester().equals(transcript.getDegreeSought().getGraduation().getSemester()) &&
			   rec.getDegreeSought().getGraduation().getYear().intValue() == transcript.getDegreeSought().getGraduation().getYear().intValue() &&
			   rec.getCertificateSought().getName().equals(transcript.getCertificateSought().getName()) &&
			   rec.getCertificateSought().getGraduation().getSemester().equals(transcript.getCertificateSought().getGraduation().getSemester()) &&
			   rec.getCertificateSought().getGraduation().getYear().intValue() == transcript.getCertificateSought().getGraduation().getYear().intValue())
			{
				if (rec.getPreviousDegrees().size() == transcript.getPreviousDegrees().size())
				{
					//previous degrees check 
					for (int index = 0; index < rec.getPreviousDegrees().size(); index++)
					{
						
						if (!rec.getPreviousDegrees().get(index).getName().equals(transcript.getPreviousDegrees().get(index).getName()) &&
							!rec.getPreviousDegrees().get(index).getGraduation().getSemester().equals(transcript.getPreviousDegrees().get(index).getGraduation().getSemester()) &&
							rec.getPreviousDegrees().get(index).getGraduation().getYear().intValue() != transcript.getPreviousDegrees().get(index).getGraduation().getYear().intValue())
						{
							update = false;
						}
					}
				}			
				//courses taken check
				if (rec.getCoursesTaken().size() == transcript.getCoursesTaken().size())
				{
					for (int index = 0; index < rec.getCoursesTaken().size(); index++)
					{
						if (!rec.getCoursesTaken().get(index).getCourse().getName().equals(transcript.getCoursesTaken().get(index).getCourse().getName()) &&
						    !rec.getCoursesTaken().get(index).getCourse().getId().equals(transcript.getCoursesTaken().get(index).getCourse().getId()) &&
						    !rec.getCoursesTaken().get(index).getCourse().getNumCredits().equals(transcript.getCoursesTaken().get(index).getCourse().getNumCredits()) &&
						    !rec.getCoursesTaken().get(index).getTerm().getSemester().equals(transcript.getCoursesTaken().get(index).getTerm().getSemester()) &&
						    rec.getCoursesTaken().get(index).getTerm().getYear().intValue() != transcript.getCoursesTaken().get(index).getTerm().getYear().intValue() &&
						    rec.getCoursesTaken().get(index).getGrade() != transcript.getCoursesTaken().get(index).getGrade())
						{
							update = false;
						}
					}
				}
				else 
				{
					update = false;
				}
				
				//milestoneSet check
				if (rec.getMilestonesSet().size() == transcript.getMilestonesSet().size())
				{
					for (int index = 0; index < rec.getMilestonesSet().size(); index++)
					{
						if (!rec.getMilestonesSet().get(index).getMilestone().equals(transcript.getMilestonesSet().get(index).getMilestone()) &&
						    !rec.getMilestonesSet().get(index).getTerm().getSemester().equals(transcript.getMilestonesSet().get(index).getTerm().getSemester()) &&
						    rec.getMilestonesSet().get(index).getTerm().getYear().intValue() != transcript.getMilestonesSet().get(index).getTerm().getYear().intValue())
						{
							update = false;
						}
					}
				}
				else 
				{
					update = false;
				}
				
				//notes check
				if (rec.getNotes().size() == transcript.getNotes().size())
				{
					for (int index = 0; index < rec.getNotes().size(); index++)
					{
						if (!rec.getNotes().get(index).equals(transcript.getNotes().get(index)))
						{
							update = false;					
						}
		
					}
				}
				else
				{
					update = false;
				}
				
				if (update)
				{
					records.add(recordIndex, transcript);
					
					String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(records);
					
					PrintWriter file = new PrintWriter(recordFilePath_);
					file.write("");
					file.append(recordsInJsonFormat);
					file.close();
					
					for (int index = 0; index < users.size(); index++)
					{
						if (users.get(index).getId().equals(userId))
						{
							users.get(index).setFirstName(records.get(recordIndex).getStudent().getFirstName());
							users.get(index).setLastName(records.get(recordIndex).getStudent().getLastName());
						}
					}
					
					String usersInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(users);
					
					file = new PrintWriter(usersFilePath_);
					file.write("");
					file.append(usersInJsonFormat);
					file.close();
					
					System.out.println("Temp field changed");
				}
				else
				{
					System.out.println("Not permitted to edit this information");
				}
			}
			else 
			{
				System.out.println("Not permitted to edit this information");
			}
		}
		else
		{
			System.out.println("Student Record doesn't exist");
		}
	}

	private void updateTemporaryTranscript(String userId, StudentRecord transcript) throws Exception{
		
		int recordIndex = -1;
		boolean update = true;
		
		//find the student record
		for (int index = 0; index < temporaryRecords.size(); index++) //find the record 
		{
			if(temporaryRecords.get(index) != null &&
			   temporaryRecords.get(index).getStudent().getId().equals(userId))
			{
				recordIndex = index;
				break;
			}
			else if (index == temporaryRecords.size())
				System.out.println("Student Record doesn't exist");
		}
		
		if (recordIndex != -1)
		{
			//now check that only degree sought, term began, first name, last name, advisors or committee member values were changed
			StudentRecord rec = temporaryRecords.get(recordIndex);
			
			if(rec.getStudent().getId().equals(transcript.getStudent().getId()) &&
			   rec.getDepartment().equals(transcript.getDepartment()) && 
			   rec.getCertificateSought().getName().equals(transcript.getCertificateSought().getName()) &&
			   rec.getCertificateSought().getGraduation().getSemester().equals(transcript.getCertificateSought().getGraduation().getSemester()) &&
			   rec.getCertificateSought().getGraduation().getYear().intValue() == transcript.getCertificateSought().getGraduation().getYear().intValue())
			{
				if (rec.getPreviousDegrees().size() == transcript.getPreviousDegrees().size())
				{
					//previous degrees check 
					for (int index = 0; index < rec.getPreviousDegrees().size(); index++)
					{
						
						if (!rec.getPreviousDegrees().get(index).getName().equals(transcript.getPreviousDegrees().get(index).getName()) &&
							!rec.getPreviousDegrees().get(index).getGraduation().getSemester().equals(transcript.getPreviousDegrees().get(index).getGraduation().getSemester()) &&
							rec.getPreviousDegrees().get(index).getGraduation().getYear().intValue() != transcript.getPreviousDegrees().get(index).getGraduation().getYear().intValue())
						{
							update = false;
						}
					}
				}			
				//courses taken check
				if (rec.getCoursesTaken().size() == transcript.getCoursesTaken().size())
				{
					for (int index = 0; index < rec.getCoursesTaken().size(); index++)
					{
						if (!rec.getCoursesTaken().get(index).getCourse().getName().equals(transcript.getCoursesTaken().get(index).getCourse().getName()) &&
						    !rec.getCoursesTaken().get(index).getCourse().getId().equals(transcript.getCoursesTaken().get(index).getCourse().getId()) &&
						    !rec.getCoursesTaken().get(index).getCourse().getNumCredits().equals(transcript.getCoursesTaken().get(index).getCourse().getNumCredits()) &&
						    !rec.getCoursesTaken().get(index).getTerm().getSemester().equals(transcript.getCoursesTaken().get(index).getTerm().getSemester()) &&
						    rec.getCoursesTaken().get(index).getTerm().getYear().intValue() != transcript.getCoursesTaken().get(index).getTerm().getYear().intValue() &&
						    rec.getCoursesTaken().get(index).getGrade() != transcript.getCoursesTaken().get(index).getGrade())
						{
							update = false;
						}
					}
				}
				else 
				{
					update = false;
				}
				
				//milestoneSet check
				if (rec.getMilestonesSet().size() == transcript.getMilestonesSet().size())
				{
					for (int index = 0; index < rec.getMilestonesSet().size(); index++)
					{
						if (!rec.getMilestonesSet().get(index).getMilestone().equals(transcript.getMilestonesSet().get(index).getMilestone()) &&
						    !rec.getMilestonesSet().get(index).getTerm().getSemester().equals(transcript.getMilestonesSet().get(index).getTerm().getSemester()) &&
						    rec.getMilestonesSet().get(index).getTerm().getYear().intValue() != transcript.getMilestonesSet().get(index).getTerm().getYear().intValue())
						{
							update = false;
						}
					}
				}
				else 
				{
					update = false;
				}
				
				//notes check
				if (rec.getNotes().size() == transcript.getNotes().size())
				{
					for (int index = 0; index < rec.getNotes().size(); index++)
					{
						if (!rec.getNotes().get(index).equals(transcript.getNotes().get(index)))
						{
							update = false;					
						}
		
					}
				}
				else
				{
					update = false;
				}
				
				if (update)
				{
					temporaryRecords.add(recordIndex, transcript);
					System.out.println("Temp field changed");
				}
				else
				{
					System.out.println("Invalid temporary change to a field");
				}
			}
			else 
			{
				System.out.println("Invalid temporary change to a field");
			}
		}
		else
		{
			System.out.println("Student record doesn't exsit");
		}
	}


	public void addNote(String userId, String note, Boolean permanent) throws Exception {
				
		if (activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")) // check if the user is a gpc
		{
			//is this a permanent change or temp change?
			if (permanent)
			{
				addPermanentNote(userId, note);
			}
			else
			{
				addTemporaryNote(userId, note);
			}
		}
		else //user isnt a gpc
		{
			System.out.print("\n"+ activeUser_.getId() + " Invalid Role \n");	
		}
	}
	
	private void addPermanentNote(String userId, String note) throws Exception {
		int recordIndex = -1;
		
		for (int index = 0; index < records.size(); index++) //find the record 
		{
			if(records.get(index) != null && records.get(index).getStudent().getId().equals(userId))
			{
				recordIndex = index;
				break;
			}
			else if (index == records.size())
				System.out.println("Student Record doesn't exist");
		}
		
		if (recordIndex != -1 && records.get(recordIndex).getDepartment().equals("COMPUTER_SCIENCE")) //check to make sure the student is in CSCE
		{
			records.get(recordIndex).addNote(note);
			//now just need to wrtie this to the studetns.txt file
			String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(records);
			
			PrintWriter file = new PrintWriter(recordFilePath_);
			file.write("");
			file.append(recordsInJsonFormat);
			file.close();
		}
		else
		{
			System.out.println(activeUser_.getId() + " Invalid Department Record Reqeust");
		}	
	}

	private void addTemporaryNote(String userId, String note) throws Exception {
		
		int recordIndex = -1;
		
		for (int index = 0; index < temporaryRecords.size(); index++) //find the record 
		{
			if(temporaryRecords.get(index) != null &&
			   temporaryRecords.get(index).getStudent().getId().equals(userId))
			{
				recordIndex = index;
				break;
			}
			else if (index == temporaryRecords.size())
				System.out.println("Student Record doesn't exist");
		}
		
		if (recordIndex != -1 && temporaryRecords.get(recordIndex).getDepartment().equals("COMPUTER_SCIENCE")) //check to make sure the student is in CSCE
		{
			temporaryRecords.get(recordIndex).addNote(note);
		}
		else
		{
			System.out.println(activeUser_.getId() + " Invalid Department Record Reqeust");
		}	
	}

	public ProgressSummary generateProgressSummary(String userId) throws Exception {
		
		return null;
	}
	
	public ProgressSummary simulateCourses(String userId, List<CourseTaken> courses) throws Exception {
		
		int recordIndex = -1;
		
		//find the student record
		for (int index = 0; index < records.size(); index++) //find the record 
		{
			if(records.get(index) != null &&
			   records.get(index).getStudent().getId().equals(userId))
			{
				recordIndex = index;
				break;
			}
			else if (index == records.size())
				System.out.println("Student Record doesn't exist");
		}
		
		if (recordIndex != -1)
		{
			temporaryRecords.get(recordIndex).setCoursesTaken(courses);
		}
		
		return generateProgressSummary(userId);
	}


	public Object getActiveUser() {
	
		return activeUser_;
	}
	

	public String getUser() {
		
		return activeUser_.getId();
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public List<StudentRecord> getRecords() {
		return records;
	}


	public void setRecords(List<StudentRecord> records) {
		this.records = records;
	}
	
	
}
