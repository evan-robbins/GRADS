package edu.sc.csce740;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GRADSDriver 
{
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to GRADS");
		GRADS grads = new GRADS();

		try 
		{
			// Have the grads system load the uses, records and courses
			// grads.loadUsers("C:/Users/New
			// Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			// grads.loadCourses("C:/Users/New
			// Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");

			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");

			// Get User Input to log into the system
			
			//grads.setUser("mmatthews");
			//System.out.println(grads.getStudentIDs());
			
			//grads.addNote("mhunt", "shouldnt see", false); //should work
			//grads.addNote("mhunt", "peep gonna fail again", true); // should work  
			
			//grads.addNote("rbob", "gonna fail", false); // should fail - not csce  
			//grads.addNote("adfa", "gonna fail", false); // should fail - no student record  
			
			//grads.setUser("mhunt");
			//grads.addNote("mhunt", "notes are gay", false); //should fail, not gpc
			
			//grads.setUser("mhunt");
			//StudentRecord temp = grads.getRecords().get(0);
			//temp.getDegreeSought().setName("UGH SCREW THIS");
			//grads.updateTranscript("mhunt", temp, false); //should work
			
			//temp.getStudent().setId("pika");
			//grads.updateTranscript("mhunt", temp, false); //shouldnlt work
			
			//temp.getStudent().setFirstName("pikachu!");
			//grads.updateTranscript("mhunt", temp, true); //should work
			
			//temp.getStudent().setFirstName("pikachu!");
			//grads.updateTranscript("mhunt", temp, true); //should work
			
			//grads.setUser("mmatthews");
			//temp.getStudent().setFirstName("Michelle");
			//grads.updateTranscript("mhunt", temp, true); //should work
			
		}
		catch (Exception e) 
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
		

		System.out.println("\n GoodBye");
	}

}
