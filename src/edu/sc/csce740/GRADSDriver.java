package edu.sc.csce740;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GRADSDriver {

	public static void main(String[] args) {
		System.out.println("Welcome to GRADS");
		GRADS grads = new GRADS();

		try {
			// Have the grads system load the uses, records and courses
			// grads.loadUsers("C:/Users/New
			// Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			// grads.loadCourses("C:/Users/New
			// Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");

			grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
			grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
			grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");

			// Get User Input to log into the system
			
			grads.setUser("mmatthews");
			System.out.println(grads.getStudentIDs());
			
			grads.addNote("mhunt", "a student is dumb", false); //should work
			grads.addNote("mhunt", "bitch gonna fail", false); // should work  
			
			grads.addNote("rbob", "bitch gonna fail", false); // should fail - not csce  
			grads.addNote("adfa", "bitch gonna fail", false); // should fail - no student record  
			
			grads.setUser("mhunt");
			grads.addNote("mhunt", "notes are gay", false); //should fail, not gpc
			
			//grads.addNote("jsmith", "a student is dumb", false); // no student record
			//grads.addNote("rbob", "a student is dumb", false); //not a csce studnet, no student record
		}
		catch (Exception e) 
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
		

		System.out.println("GoodBye");


	}

}
