package edu.sc.csce740;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GRADSDriver {

	public static void main(String[] args) 
	{
		System.out.println("Welcome to GRADS");
		GRADS grads = new GRADS();
		
		//LOADING DATABASES
		try
		{
		//Have the grads system load the uses, records and courses 
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
		grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");
			
		//grads.loadUsers("C:/Users//Documents/Csce740/GRADS_Materials/GRADS_Materials/data/users.txt");
		//grads.loadCourses("C:/Users/Hero/Documents/Csce740/GRADS_Materials/GRADS_Materials/data/courses.txt");	
		//grads.loadRecords("C:/Users/Hero/Documents/Csce740/GRADS_Materials/GRADS_Materials/data/students.txt");
			
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}

		
		//TESTING SETUSER FUNCTION
		try
		{
		grads.setUser("mhunt");
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}

		//TESTING CLEARSESSION FUNCTION
		try
		{
		//System.out.println(grads.getactiveUser_().toString());
		//grads.clearSession();
		//System.out.println(grads.getactiveUser_().toString());
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
		
		//TESTING GETTRANSCRIPT FUNCTION
		try
		{
		//StudentRecord test = grads.getTranscript("mhunt");
		//System.out.println(test.toString());
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
		
		//TESTING GENERATEPROGRESSSUMMARY FUNCTION
		try
		{
		ProgressSummary test = grads.generateProgressSummary("mhunt");
		System.out.println(test.toString());
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
		
	}

}
