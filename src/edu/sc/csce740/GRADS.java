package edu.sc.csce740;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GRADS implements GRADSIntf 
{
	private List<User> users;
	private List<Course> courses;
	private List<StudentRecord> records;
	
	private User activeUser_; //this keeps track of the id of the user
	
	
	public void loadUsers(String usersFile) throws Exception 
	{				
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (usersFile));
		
		users = gson.fromJson(br, new TypeToken <List<User>>(){}.getType());
		System.out.println(this.users);
	}

	
	public void loadCourses(String coursesFile) throws Exception 
	{
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (coursesFile));
		
		this.courses = gson.fromJson(br, new TypeToken <List<Course>>(){}.getType());
		System.out.println(this.courses);
	}

	
	public void loadRecords(String recordsFile) throws Exception 
	{
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (recordsFile));
		
		this.records = gson.fromJson(br, new TypeToken <List<StudentRecord>>(){}.getType());
		System.out.println(this.records);
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

	
	public void clearSession() throws Exception {
		
		String temp = "Invalid User";
		activeUser_.setId(temp);
		activeUser_.setFirstName(temp);
		activeUser_.setLastName(temp);
		activeUser_.setRole(temp);
		activeUser_.setDepartment(temp);
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
		
		return null;
	}

	
	public void updateTranscript(String userId, StudentRecord transcript, Boolean permanent) throws Exception {

		
	}

	
	public void addNote(String userId, String note, Boolean permanent) throws Exception {
		
		System.out.println();
		
		String studentId;
		StudentRecord tempRecord = new StudentRecord();
		int recordIndex = -1;
		
		// check if the user is a gpc
		if (activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR"))
		{
			//is this a permanent change or temp change?
			if (permanent)
			{
				//write this to the json file
				
				
			}
			else
			{
				//just make a temp change to the record
				//get the record
				for (int index = 0; index < records.size(); index++)
				{
					studentId = records.get(index).getStudent().getId();
					if(studentId.equals(userId))
					{
						//tempRecord = records.get(index);
						recordIndex = index;
						break;
					}
					else if (index == records.size())
						System.out.println("Student Record doesn't exist");
				}
				
				//check to make sure the student is in CSCE
				if (recordIndex != -1 &&
					records.get(recordIndex).getDepartment().equals("COMPUTER_SCIENCE"))
				{
					//then change the note
					records.get(recordIndex).addNote(note);
				}
				else
				{
					System.out.println(activeUser_.getId() + "Invalid Department Record Reqeust \n");
				}
				
				System.out.print(records.get(recordIndex));	
			}
		}
		else //user isnt a gpc
		{
			System.out.print(activeUser_.getId() + " Invalid Role \n");	
		}
	}

	
	public ProgressSummary generateProgressSummary(String userId) throws Exception {
		
		return null;
	}

	
	public ProgressSummary simulateCourses(String userId, List<CourseTaken> courses) throws Exception {
		
		return null;
	}


	public Object getActiveUser() {
	
		return activeUser_;
	}
	
	public String getUser() {
		
		return activeUser_.getId();
	}
}
