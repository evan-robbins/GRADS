package edu.sc.csce740;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GRADS implements GRADSIntf 
{
	//Class Variables
	private List<User> users;
	private List<Course> courses;
	private List<StudentRecord> records;
	private User activeUser_;
	
	//Getters and Setters for activeUser_
	public User getactiveUser_() {
		return activeUser_;
	}
	public void setactiveUser_(User activeUser_) {
		this.activeUser_ = activeUser_;
	}

	@Override
	public void loadUsers(String usersFile) throws Exception 
	{				
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (usersFile));
		
		users = gson.fromJson(br, new TypeToken <List<User>>(){}.getType());
		//System.out.println(this.users);
	}

	@Override
	public void loadCourses(String coursesFile) throws Exception 
	{
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (coursesFile));
		
		this.courses = gson.fromJson(br, new TypeToken <List<Course>>(){}.getType());
		//System.out.println(this.courses);
	}

	@Override
	public void loadRecords(String recordsFile) throws Exception 
	{
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader (recordsFile));
		
		this.records = gson.fromJson(br, new TypeToken <List<StudentRecord>>(){}.getType());
		//System.out.println(this.records);
	}

	@Override
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

	@Override
	public void clearSession() throws Exception {
		String temp = "Invalid User";
		this.activeUser_.setId(temp);
		this.activeUser_.setFirstName(temp);
		this.activeUser_.setLastName(temp);
		this.activeUser_.setRole(temp);
		this.activeUser_.setDepartment(temp);
	}

	@Override
	public String getUser() {
		String userInfo = activeUser_.getId();
		return userInfo;
	}

	@Override
	public List<String> getStudentIDs() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
		ProgressSummary stuProg = new ProgressSummary();
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
			System.out.println(activeUser_.getId() + " is requesting their Progress Report.");
			for(int index=0; index < records.size(); index++)
			{
				if(userId.equals(records.get(index).getStudent().getId()))
				{
					stuProg.setStudent(records.get(index).getStudent());
					stuProg.setDepartment(records.get(index).getDepartment());
					stuProg.setTermBegan(records.get(index).getTermBegan());
					stuProg.setDegreeSought(records.get(index).getDegreeSought());
					stuProg.setCertificateSought(records.get(index).getCertificateSought());
					stuProg.setAdvisors(records.get(index).getAdvisors());
					stuProg.setCommittee(records.get(index).getCommittee());
					
				}
			}	
		}
	
		//CS GPC is requesting one of their CS student's SR
		if(!activeUser_.getId().equals(inputUser.getId())&&activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")&&activeUser_.getDepartment().equals(inputUser.getDepartment())){
			System.out.println("GPC " + activeUser_.getId() + " is requesting " + inputUser.getId() + "'s Progress Report.");
			for(int index=0; index < records.size(); index++)
			{
				if(userId.equals(records.get(index).getStudent().getId()))
				{
					stuProg.setStudent(records.get(index).getStudent());
					stuProg.setDepartment(records.get(index).getDepartment());
					stuProg.setTermBegan(records.get(index).getTermBegan());
					stuProg.setDegreeSought(records.get(index).getDegreeSought());
					stuProg.setCertificateSought(records.get(index).getCertificateSought());
					stuProg.setAdvisors(records.get(index).getAdvisors());
					stuProg.setCommittee(records.get(index).getCommittee());
				}
			}
		}
		
		return stuProg;
	}

	@Override
	public ProgressSummary simulateCourses(String userId, List<CourseTaken> courses) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
