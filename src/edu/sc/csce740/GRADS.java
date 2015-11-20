package edu.sc.csce740;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GRADS implements GRADSIntf 
{
	private List<User> users;
	private List<Course> courses;
	private List<StudentRecord> records;
	
	@Override
	public void loadUsers(String usersFile) throws Exception 
	{				
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (usersFile));
		
		users = gson.fromJson(br, new TypeToken <List<User>>(){}.getType());
		System.out.println(this.users);
	}

	@Override
	public void loadCourses(String coursesFile) throws Exception 
	{
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (coursesFile));
		
		this.courses = gson.fromJson(br, new TypeToken <List<Course>>(){}.getType());
		System.out.println(this.courses);
	}

	@Override
	public void loadRecords(String recordsFile) throws Exception 
	{
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (recordsFile));
		
		this.records = gson.fromJson(br, new TypeToken <List<StudentRecord>>(){}.getType());
		System.out.println(this.records);
	}

	@Override
	public void setUser(String userId) throws Exception 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSession() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getStudentIDs() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentRecord getTranscript(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTranscript(String userId, StudentRecord transcript, Boolean permanent) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNote(String userId, String note, Boolean permanent) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProgressSummary generateProgressSummary(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgressSummary simulateCourses(String userId, List<CourseTaken> courses) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
