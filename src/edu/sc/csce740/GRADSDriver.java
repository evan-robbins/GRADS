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
		
		try
		{
		//Have the grads system load the uses, records and courses 
		grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
		grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
		//grads.loadRecords("C:/Users/Hero/workspace/GRADS/bin/edu/sc/csce740/GRADS_Materials/data/students.txt");
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}

		//watch for input from the user and respond 
		for (;;)
		{
			
		}
		

	}

}
