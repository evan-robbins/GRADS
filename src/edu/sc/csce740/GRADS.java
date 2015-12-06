package edu.sc.csce740;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GRADS implements GRADSIntf {
	// Class Variables
	private List<User> users;
	private List<Course> courses;
	private List<StudentRecord> records;
	private List<StudentRecord> temporaryRecords; // if the user makes a temp
													// change and then a perma
													// change, perma changes
													// will be added

	private String usersFilePath_ = "";
	private String recordFilePath_ = "";
	private boolean updateTranscriptFailed = false;
	private boolean updateNoteFailed= false;
	

	private User activeUser_ = null; // this keeps track of the id of the user

	/**
	 * Gets the active user logged into the system
	 * 
	 * @return the users logged into the system
	 */
	public User getactiveUser_() {
		return activeUser_;
	}

	/**
	 * Sets the active user of the system @param activeUser_ is the user
	 * currently logged into grads @throws
	 */
	public void setactiveUser_(User activeUser_) {
		this.activeUser_ = activeUser_;
	}

	/**
	 * Loads the list of system usernames and permissions.
	 * 
	 * @param usersFile
	 *            the filename of the users file.
	 * @throws Exception
	 *             for I/O errors. SEE NOTE IN CLASS HEADER.
	 */
	public void loadUsers(String usersFile) throws Exception {
		try {
			usersFilePath_ = usersFile;

			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(usersFile));

			users = gson.fromJson(br, new TypeToken<List<User>>() {
			}.getType());
			br.close();
		} catch (Exception e) {

			System.out.println("Error in loadUsers: " + e.getMessage());
		}
	}
	// System.out.println(this.users);

	/**
	 * Loads the list of valid courses.
	 * 
	 * @param coursesFile
	 *            the filename of the users file.
	 * @throws Exception
	 *             for I/O errors. SEE NOTE IN CLASS HEADER.
	 */
	public void loadCourses(String coursesFile) throws Exception {
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(coursesFile));

			this.courses = gson.fromJson(br, new TypeToken<List<Course>>() {
			}.getType());
			// System.out.println(this.courses);
			br.close();
		} catch (Exception e) {

			System.out.println("Error in loadCourses: " + e.getMessage());
		}
	}

	/**
	 * Loads the list of system transcripts.
	 * 
	 * @param recordsFile
	 *            the filename of the transcripts file.
	 * @throws Exception
	 *             for I/O errors. SEE NOTE IN CLASS HEADER.
	 */
	public void loadRecords(String recordsFile) throws Exception {
		try {
			recordFilePath_ = recordsFile;

			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(recordsFile));
			this.records = gson.fromJson(br, new TypeToken<List<StudentRecord>>() {
			}.getType());
			br.close();

			br = new BufferedReader(new FileReader(recordsFile));
			this.temporaryRecords = gson.fromJson(br, new TypeToken<List<StudentRecord>>() {
			}.getType());
			br.close();
		} catch (Exception e) {

			System.out.println("Error in loadRecords: " + e.getMessage());
		}
	}

	/**
	 * Sets the user id of the user currently using the system.
	 * 
	 * @param userId
	 *            the id of the user to log in.
	 * @throws Exception
	 *             if the user id is invalid. SEE NOTE IN CLASS HEADER.
	 */
	public void setUser(String userId) throws Exception {
		boolean validUser = false;

		for (int index = 0; index < users.size(); index++) {
			if (userId.equals(users.get(index).getId())) {
				if (users.get(index).getDepartment().equals("COMPUTER_SCIENCE")) {
					validUser = true;
					activeUser_ = users.get(index);
					//System.out.println(users.get(index).getId() + " has access to GRADS");
				} else {
					validUser = true;
					System.out.println("Invalid Major");
				}

			}
		}

		if (!validUser) {
			System.out.println("Invalid UserID");
		}
	}

	/**
	 * Closes the current session, logs the user out, and clears and session
	 * data.
	 * 
	 * @throws Exception
	 *             if the user id is invalid. SEE NOTE IN CLASS HEADER.
	 */
	public void clearSession() throws Exception {

		try {
			String temp = "Invalid User";
			this.activeUser_.setId(temp);
			this.activeUser_.setFirstName(temp);
			this.activeUser_.setLastName(temp);
			this.activeUser_.setRole(temp);
			this.activeUser_.setDepartment(temp);

			List<User> tempUsers = new ArrayList<User>();
			List<Course> tempCourses = new ArrayList<Course>();
			List<StudentRecord> tempRecords = new ArrayList<StudentRecord>();

			users = tempUsers;
			courses = tempCourses;
			records = tempRecords;
			temporaryRecords = tempRecords;
		} catch (Exception e) {

			System.out.println("Error in clearSession: " + e.getMessage());
		}
	}

	/**
	 * Gets the user id of the user currently using the system.
	 * 
	 * @return the user id of the user currently using the system.
	 */
	public String getUser() {
		String userInfo = null;
		try {
			userInfo = activeUser_.getId();
			return userInfo;
		} catch (Exception e) {

			System.out.println("Error in getUser: " + e.getMessage());
			return userInfo;
		}

	}

	/**
	 * Gets a list of the userIds of the students that a GPC can view.
	 * 
	 * @return a list containing the userId of for each student in the system
	 *         belonging to the current user
	 * @throws Exception
	 *             is the current user is not a GPC.
	 */
	public List<String> getStudentIDs() throws Exception {

		List<String> studentIds = new ArrayList<String>();
		try {
			if (activeUser_ != null
					&& activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")) {
				for (int index = 0; index < users.size(); index++) {
					if (users.get(index).getRole().equals("STUDENT"))
						studentIds.add(users.get(index).getId());
				}
				return studentIds;
			}
			else
			{
				return null;
			}
			
		} catch (Exception e) {

			System.out.println("Error in getStudentIDs: " + e.getMessage());
			

			return null;
		}
	}

	/**
	 * Gets the raw student record data for a given userId.
	 * 
	 * @param userId
	 *            the identifier of the student.
	 * @return the student record data.
	 * @throws Exception
	 *             if the form data could not be retrieved. SEE NOTE IN CLASS
	 *             HEADER.
	 */
	public StudentRecord getTranscript(String userId) throws Exception {

		StudentRecord stuRec = new StudentRecord();
		User inputUser = new User();
		boolean validUser = false;

		try {
			for (int index = 0; index < users.size(); index++) {
				if (users.get(index) != null && userId.equals(users.get(index).getId())) {
					validUser = true;
					inputUser = users.get(index);
				}
			}

			if (!validUser) {
				System.out.println(userId + " is an invalid userID");
				return null;
			}

			// Student is requesting their own SR
			if (activeUser_.getId().equals(inputUser.getId()) && activeUser_.getRole().equals("STUDENT")) {

				// System.out.println(activeUser_.getId() + " is requesting
				// their Student Record.");
				for (int index = 0; index < temporaryRecords.size(); index++) {
					if (temporaryRecords.get(index) != null
							&& userId.equals(temporaryRecords.get(index).getStudent().getId())) {
						stuRec = temporaryRecords.get(index);
					}
				}
			}
			// CS GPC is requesting one of their CS student's SR
			else if (!activeUser_.getId().equals(inputUser.getId())
					&& activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")
					&& activeUser_.getDepartment().equals(inputUser.getDepartment())) {

				// System.out.println("GPC " + activeUser_.getId() + " is
				// requesting " + inputUser.getId() + "'s Student Record.");
				for (int index = 0; index < temporaryRecords.size(); index++) {
					if (temporaryRecords.get(index) != null
							&& userId.equals(temporaryRecords.get(index).getStudent().getId())) {
						stuRec = temporaryRecords.get(index);
					}
				}
			} else {
				System.out.println("Invalid attempt to access student record");
				return null;

			}
			return stuRec;
		} catch (Exception e) {

			System.out.println("Error in addNote: " + e.getMessage());
			StudentRecord nullRecord = new StudentRecord();

			return nullRecord;
		}

	}

	/**
	 * Saves a new set of student data to the records data.
	 * 
	 * @param userId
	 *            the student ID to overwrite.
	 * @param transcript
	 *            the new student record
	 * @param permanent
	 *            a status flag indicating whether (if false) to make a
	 *            temporary edit to the in-memory structure or (if true) a
	 *            permanent edit.
	 * @throws Exception
	 *             if the transcript data could not be saved or failed a
	 *             validity check. SEE NOTE IN CLASS HEADER.
	 */
	public void updateTranscript(String userId, StudentRecord transcript, Boolean permanent) throws Exception {
		updateTranscriptFailed = false;
		
		try {
			//check if the user is a gpc
			if (activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR"))																			
			{
				// is this a permanent change or temp change?
				if (permanent) {
					updatePermanentTranscriptGPC(userId, transcript);
				} else {
					updateTemporaryTranscriptGPC(userId, transcript);
				}
			} else // user is a student
			{
				if (activeUser_.getId().equals(userId)) {
					if (permanent) {
						updatePermanentTranscript(userId, transcript);
					} else {
						updateTemporaryTranscript(userId, transcript);
					}
				} else {
					System.out.println("Invalid attempt to access another student's student record");
					updateTranscriptFailed = true;
				}
			}
		} catch (Exception e) {

			System.out.println("Error in updateTranscript: " + e.getMessage());
			updateTranscriptFailed = true;
		}
	}

	/**
	 * Updates the student's transcript permanently if done by a gpc
	 * 
	 * @param userId
	 *            is the students userId
	 * @param transcript
	 *            is the student record of the student
	 * @return
	 * @throws an
	 *             exception if there's problem updating the transcript
	 */
	private void updatePermanentTranscriptGPC(String userId, StudentRecord transcript) throws Exception {

		int recordIndex = -1;
		boolean update = true;

		// find the student record
		for (int index = 0; index < records.size(); index++) // find the record
		{
			if (records.get(index) != null && records.get(index).getStudent().getId().equals(userId)) {
				recordIndex = index;
				break;
			} else if (index == records.size())
				System.out.println("Student Record doesn't exist");
		}

		if (recordIndex != -1) {
			// now check that only degree sought, term began, first name, last
			// name, advisors or committee member values were changed
			StudentRecord rec = records.get(recordIndex);

			if (rec.getStudent().getId().equals(transcript.getStudent().getId())
					&& rec.getDepartment().equals(transcript.getDepartment())
					&& rec.getCertificateSought().getName().equals(transcript.getCertificateSought().getName())
					&& rec.getCertificateSought().getGraduation().getSemester()
							.equals(transcript.getCertificateSought().getGraduation().getSemester())
					&& rec.getCertificateSought().getGraduation().getYear().intValue() == transcript
							.getCertificateSought().getGraduation().getYear().intValue()) {
				if (rec.getPreviousDegrees().size() == transcript.getPreviousDegrees().size()) {
					// previous degrees check
					for (int index = 0; index < rec.getPreviousDegrees().size(); index++) {

						if (!rec.getPreviousDegrees().get(index).getName()
								.equals(transcript.getPreviousDegrees().get(index).getName())
								&& !rec.getPreviousDegrees().get(index).getGraduation().getSemester()
										.equals(transcript.getPreviousDegrees().get(index).getGraduation()
												.getSemester())
								&& rec.getPreviousDegrees().get(index).getGraduation().getYear()
										.intValue() != transcript.getPreviousDegrees().get(index).getGraduation()
												.getYear().intValue()) {
							update = false;
						}
					}
				}

				if (update) {
					records.add(recordIndex, transcript);

					String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(records);

					PrintWriter file = new PrintWriter(recordFilePath_);
					file.write("");
					file.append(recordsInJsonFormat);
					file.close();

					// update the users information
					for (int index = 0; index < users.size(); index++) {
						if (users.get(index).getId().equals(userId)) {
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
				} else {
					System.out.println("Invalid temporary change to a field");
				}
			} else {
				System.out.println("Invalid temporary change to a field");
			}
		} else // add the student record to the temporary list if it doesn't
				// exist
		{
			records.add(transcript);

			String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(records);

			PrintWriter file = new PrintWriter(recordFilePath_);
			file.write("");
			file.append(recordsInJsonFormat);
			file.close();

			// update the users information
			for (int index = 0; index < users.size(); index++) {
				if (users.get(index).getId().equals(userId)) {
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

	/**
	 * Updates the student's transcript temporary if done by a gpc
	 * 
	 * @param userId
	 *            is the students userId
	 * @param transcript
	 *            is the student record of the student
	 * @return
	 * @throws an
	 *             exception if there's problem updating the transcript
	 */
	private void updateTemporaryTranscriptGPC(String userId, StudentRecord transcript) {

		int recordIndex = -1;
		boolean update = true;

		// find the student record
		for (int index = 0; index < temporaryRecords.size(); index++) // find
																		// the
																		// record
		{
			if (temporaryRecords.get(index) != null
					&& temporaryRecords.get(index).getStudent().getId().equals(userId)) {
				recordIndex = index;
				break;
			} else if (index == temporaryRecords.size())
				System.out.println("Student Record doesn't exist");
		}

		if (recordIndex != -1) {
			// now check that only degree sought, term began, first name, last
			// name, advisors or committee member values were changed
			StudentRecord rec = temporaryRecords.get(recordIndex);

			if (rec.getStudent().getId().equals(transcript.getStudent().getId())
					&& rec.getDepartment().equals(transcript.getDepartment())
					&& rec.getCertificateSought().getName().equals(transcript.getCertificateSought().getName())
					&& rec.getCertificateSought().getGraduation().getSemester()
							.equals(transcript.getCertificateSought().getGraduation().getSemester())
					&& rec.getCertificateSought().getGraduation().getYear().intValue() == transcript
							.getCertificateSought().getGraduation().getYear().intValue()) {
				if (rec.getPreviousDegrees().size() == transcript.getPreviousDegrees().size()) {
					// previous degrees check
					for (int index = 0; index < rec.getPreviousDegrees().size(); index++) {

						if (!rec.getPreviousDegrees().get(index).getName()
								.equals(transcript.getPreviousDegrees().get(index).getName())
								&& !rec.getPreviousDegrees().get(index).getGraduation().getSemester()
										.equals(transcript.getPreviousDegrees().get(index).getGraduation()
												.getSemester())
								&& rec.getPreviousDegrees().get(index).getGraduation().getYear()
										.intValue() != transcript.getPreviousDegrees().get(index).getGraduation()
												.getYear().intValue()) {
							update = false;
						}
					}
				}

				if (update) {
					temporaryRecords.add(recordIndex, transcript);
					System.out.println("Temp field changed");
				} else {
					System.out.println("Invalid temporary change to a field");
				}
			} else {
				System.out.println("Invalid temporary change to a field");
			}
		} else // add the student record to the temporary list if it doesn't
				// exist
		{
			temporaryRecords.add(transcript);
			System.out.println("Added Temp Student Record");
		}
	}

	/**
	 * Updates the student's transcript permanent if done by the student
	 * 
	 * @param userId
	 *            is the students userId
	 * @param transcript
	 *            is the student record of the student
	 * @return
	 * @throws an
	 *             exception if there's problem updating the transcript
	 */
	private void updatePermanentTranscript(String userId, StudentRecord transcript) throws Exception {

		int recordIndex = -1;
		boolean update = true;

		// find the student record
		for (int index = 0; index < records.size(); index++) // find the record
		{
			if (records.get(index) != null && records.get(index).getStudent().getId().equals(userId)) {
				recordIndex = index;
				break;
			} else if (index == records.size())
				System.out.println("Student Record doesn't exist");
		}

		if (recordIndex != -1) {
			StudentRecord rec = records.get(recordIndex);

			if (rec.getStudent().getId().equals(transcript.getStudent().getId())
					&& rec.getDepartment().equals(transcript.getDepartment())
					&& rec.getDegreeSought().getName().equals(transcript.getDegreeSought().getName())
					&& rec.getDegreeSought().getGraduation().getSemester()
							.equals(transcript.getDegreeSought().getGraduation().getSemester())
					&& rec.getDegreeSought().getGraduation().getYear().intValue() == transcript.getDegreeSought()
							.getGraduation().getYear().intValue()
					&& rec.getCertificateSought().getName().equals(transcript.getCertificateSought().getName())
					&& rec.getCertificateSought().getGraduation().getSemester()
							.equals(transcript.getCertificateSought().getGraduation().getSemester())
					&& rec.getCertificateSought().getGraduation().getYear().intValue() == transcript
							.getCertificateSought().getGraduation().getYear().intValue()) {
				if (rec.getPreviousDegrees().size() == transcript.getPreviousDegrees().size()) {
					// previous degrees check
					for (int index = 0; index < rec.getPreviousDegrees().size(); index++) {

						if (!rec.getPreviousDegrees().get(index).getName()
								.equals(transcript.getPreviousDegrees().get(index).getName())
								&& !rec.getPreviousDegrees().get(index).getGraduation().getSemester()
										.equals(transcript.getPreviousDegrees().get(index).getGraduation()
												.getSemester())
								&& rec.getPreviousDegrees().get(index).getGraduation().getYear()
										.intValue() != transcript.getPreviousDegrees().get(index).getGraduation()
												.getYear().intValue()) {
							update = false;
						}
					}
				}
				// courses taken check
				if (rec.getCoursesTaken().size() == transcript.getCoursesTaken().size()) {
					for (int index = 0; index < rec.getCoursesTaken().size(); index++) {
						if (!rec.getCoursesTaken().get(index).getCourse().getName()
								.equals(transcript.getCoursesTaken().get(index).getCourse().getName())
								&& !rec.getCoursesTaken().get(index).getCourse().getId()
										.equals(transcript.getCoursesTaken().get(index).getCourse().getId())
								&& !rec.getCoursesTaken().get(index).getCourse().getNumCredits()
										.equals(transcript.getCoursesTaken().get(index).getCourse().getNumCredits())
								&& !rec.getCoursesTaken().get(index).getTerm().getSemester()
										.equals(transcript.getCoursesTaken().get(index).getTerm().getSemester())
								&& rec.getCoursesTaken().get(index).getTerm().getYear().intValue() != transcript
										.getCoursesTaken().get(index).getTerm().getYear().intValue()
								&& rec.getCoursesTaken().get(index).getGrade() != transcript.getCoursesTaken()
										.get(index).getGrade()) {
							update = false;
						}
					}
				} else {
					update = false;
				}

				// milestoneSet check
				if (rec.getMilestonesSet().size() == transcript.getMilestonesSet().size()) {
					for (int index = 0; index < rec.getMilestonesSet().size(); index++) {
						if (!rec.getMilestonesSet().get(index).getMilestone()
								.equals(transcript.getMilestonesSet().get(index).getMilestone())
								&& !rec.getMilestonesSet().get(index).getTerm().getSemester()
										.equals(transcript.getMilestonesSet().get(index).getTerm().getSemester())
								&& rec.getMilestonesSet().get(index).getTerm().getYear().intValue() != transcript
										.getMilestonesSet().get(index).getTerm().getYear().intValue()) {
							update = false;
						}
					}
				} else {
					update = false;
				}

				// notes check
				if (rec.getNotes().size() == transcript.getNotes().size()) {
					for (int index = 0; index < rec.getNotes().size(); index++) {
						if (!rec.getNotes().get(index).equals(transcript.getNotes().get(index))) {
							update = false;
						}

					}
				} else {
					update = false;
				}

				if (update) {
					records.add(recordIndex, transcript);

					String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(records);

					PrintWriter file = new PrintWriter(recordFilePath_);
					file.write("");
					file.append(recordsInJsonFormat);
					file.close();

					for (int index = 0; index < users.size(); index++) {
						if (users.get(index).getId().equals(userId)) {
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
				} else {
					System.out.println("Not permitted to edit this information");
				}
			} else {
				System.out.println("Not permitted to edit this information");
			}
		} else {
			System.out.println("Student Record doesn't exist");
		}
	}

	/**
	 * Updates the student's transcript temporary if done by a student
	 * 
	 * @param userId
	 *            is the students userId
	 * @param transcript
	 *            is the student record of the student
	 * @return
	 * @throws an
	 *             exception if there's problem updating the transcript
	 */
	private void updateTemporaryTranscript(String userId, StudentRecord transcript) throws Exception {

		int recordIndex = -1;
		boolean update = true;

		// find the student record
		for (int index = 0; index < temporaryRecords.size(); index++) // find
																		// the
																		// record
		{
			if (temporaryRecords.get(index) != null
					&& temporaryRecords.get(index).getStudent().getId().equals(userId)) {
				recordIndex = index;
				break;
			} else if (index == temporaryRecords.size())
				System.out.println("Student Record doesn't exist");
		}

		if (recordIndex != -1) {
			// now check that only degree sought, term began, first name, last
			// name, advisors or committee member values were changed
			StudentRecord rec = temporaryRecords.get(recordIndex);

			if (rec.getStudent().getId().equals(transcript.getStudent().getId())
					&& rec.getDepartment().equals(transcript.getDepartment())
					&& rec.getCertificateSought().getName().equals(transcript.getCertificateSought().getName())
					&& rec.getCertificateSought().getGraduation().getSemester()
							.equals(transcript.getCertificateSought().getGraduation().getSemester())
					&& rec.getCertificateSought().getGraduation().getYear().intValue() == transcript
							.getCertificateSought().getGraduation().getYear().intValue()) {
				if (rec.getPreviousDegrees().size() == transcript.getPreviousDegrees().size()) {
					// previous degrees check
					for (int index = 0; index < rec.getPreviousDegrees().size(); index++) {

						if (!rec.getPreviousDegrees().get(index).getName()
								.equals(transcript.getPreviousDegrees().get(index).getName())
								&& !rec.getPreviousDegrees().get(index).getGraduation().getSemester()
										.equals(transcript.getPreviousDegrees().get(index).getGraduation()
												.getSemester())
								&& rec.getPreviousDegrees().get(index).getGraduation().getYear()
										.intValue() != transcript.getPreviousDegrees().get(index).getGraduation()
												.getYear().intValue()) {
							update = false;
						}
					}
				}
				// courses taken check
				if (rec.getCoursesTaken().size() == transcript.getCoursesTaken().size()) {
					for (int index = 0; index < rec.getCoursesTaken().size(); index++) {
						if (!rec.getCoursesTaken().get(index).getCourse().getName()
								.equals(transcript.getCoursesTaken().get(index).getCourse().getName())
								&& !rec.getCoursesTaken().get(index).getCourse().getId()
										.equals(transcript.getCoursesTaken().get(index).getCourse().getId())
								&& !rec.getCoursesTaken().get(index).getCourse().getNumCredits()
										.equals(transcript.getCoursesTaken().get(index).getCourse().getNumCredits())
								&& !rec.getCoursesTaken().get(index).getTerm().getSemester()
										.equals(transcript.getCoursesTaken().get(index).getTerm().getSemester())
								&& rec.getCoursesTaken().get(index).getTerm().getYear().intValue() != transcript
										.getCoursesTaken().get(index).getTerm().getYear().intValue()
								&& rec.getCoursesTaken().get(index).getGrade() != transcript.getCoursesTaken()
										.get(index).getGrade()) {
							update = false;
						}
					}
				} else {
					update = false;
				}

				// milestoneSet check
				if (rec.getMilestonesSet().size() == transcript.getMilestonesSet().size()) {
					for (int index = 0; index < rec.getMilestonesSet().size(); index++) {
						if (!rec.getMilestonesSet().get(index).getMilestone()
								.equals(transcript.getMilestonesSet().get(index).getMilestone())
								&& !rec.getMilestonesSet().get(index).getTerm().getSemester()
										.equals(transcript.getMilestonesSet().get(index).getTerm().getSemester())
								&& rec.getMilestonesSet().get(index).getTerm().getYear().intValue() != transcript
										.getMilestonesSet().get(index).getTerm().getYear().intValue()) {
							update = false;
						}
					}
				} else {
					update = false;
				}

				// notes check
				if (rec.getNotes().size() == transcript.getNotes().size()) {
					for (int index = 0; index < rec.getNotes().size(); index++) {
						if (!rec.getNotes().get(index).equals(transcript.getNotes().get(index))) {
							update = false;
						}

					}
				} else {
					update = false;
				}

				if (update) {
					temporaryRecords.add(recordIndex, transcript);
					System.out.println("Temp field changed");
				} else {
					System.out.println("Invalid temporary change to a field");
				}
			} else {
				System.out.println("Invalid temporary change to a field");
			}
		} else {
			System.out.println("Student record doesn't exsit");
		}
	}

	/**
	 * Appends a note to a student record.
	 * 
	 * @param userId
	 *            the student ID to add a note to.
	 * @param note
	 *            the note to append
	 * @param permanent
	 *            a status flag indicating whether (if false) to make a
	 *            temporary edit to the in-memory structure or (if true) a
	 *            permanent edit.
	 * @throws Exception
	 *             if the note could not be saved or a non-GPC tries to call.
	 *             SEE NOTE IN CLASS HEADER.
	 */
	public void addNote(String userId, String note, Boolean permanent) throws Exception {
		
		updateNoteFailed = false;
		 
		try {
			if (activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")) 
			{
				// is this a permanent change or temp change?
				if (permanent) {
					addPermanentNote(userId, note);
				} else {
					addTemporaryNote(userId, note);
				}
			} else // user isnt a gpc
			{
				System.out.print("\n" + activeUser_.getId() + " Invalid Role \n");
				updateNoteFailed = true;
				
			}
		} catch (Exception e) {
			
			System.out.println("Error in addNote: " + e.getMessage());
			updateNoteFailed = true;

		}

	}

	/**
	 * Adds a permanent note to the student record
	 * 
	 * @param userId
	 *            the student to generate the note for
	 * @param the
	 *            note to add
	 * @returns n/a
	 * @throws Exception
	 *             if the note could not be added. SEE NOTE IN CLASS HEADER.
	 */
	private void addPermanentNote(String userId, String note) throws Exception {
		int recordIndex = -1;

		for (int index = 0; index < records.size(); index++) // find the record
		{
			if (records.get(index) != null && records.get(index).getStudent().getId().equals(userId)) {
				recordIndex = index;
				break;
			} else if (index == records.size())
				System.out.println("Student Record doesn't exist");
		}

		if (recordIndex != -1 && records.get(recordIndex).getDepartment().equals("COMPUTER_SCIENCE")) 
		{
			records.get(recordIndex).addNote(note);
			// now just need to wrtie this to the studetns.txt file
			String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(records);

			PrintWriter file = new PrintWriter(recordFilePath_);
			file.write("");
			file.append(recordsInJsonFormat);
			file.close();
		} else {
			System.out.println(activeUser_.getId() + " Invalid Department Record Reqeust");
		}
	}

	/**
	 * Adds a Temporary note to the student record
	 * 
	 * @param userId
	 *            the student to generate the note for
	 * @param the
	 *            note to add
	 * @returns n/a
	 * @throws Exception
	 *             if the note could not be added. SEE NOTE IN CLASS HEADER.
	 */
	private void addTemporaryNote(String userId, String note) throws Exception {

		int recordIndex = -1;

		for (int index = 0; index < temporaryRecords.size(); index++) 
		{
			if (temporaryRecords.get(index) != null
					&& temporaryRecords.get(index).getStudent().getId().equals(userId)) {
				recordIndex = index;
				break;
			} else if (index == temporaryRecords.size())
				System.out.println("Student Record doesn't exist");
		}

		if (recordIndex != -1 && temporaryRecords.get(recordIndex).getDepartment().equals("COMPUTER_SCIENCE")) 
		{
			temporaryRecords.get(recordIndex).addNote(note);
		} else {
			System.out.println(activeUser_.getId() + " Invalid Department Record Reqeust");
		}
	}

	/**
	 * Generates progress summary
	 * 
	 * @param userId
	 *            the student to generate the record for.
	 * @returns the student's progress summary in a data class matching the I/O
	 *          file.
	 * @throws Exception
	 *             if the progress summary could not be generated. SEE NOTE IN
	 *             CLASS HEADER.
	 */
	public ProgressSummary generateProgressSummary(String userId) throws Exception {
		ProgressSummary stuProg = new ProgressSummary();
		User inputUser = new User();
		boolean validUser = false;

		try {

			for (int index = 0; index < users.size(); index++) {
				if (users.get(index) != null && userId.equals(users.get(index).getId())) {
					validUser = true;
					inputUser = users.get(index);
					break;
				}
			}

			if (!validUser) {
				System.out.println(userId + " is an invalid userID");
				return null;
			}

			// Student is requesting their own SR
			if (activeUser_.getId().equals(inputUser.getId()) && activeUser_.getRole().equals("STUDENT")) {
				System.out.println(activeUser_.getId() + " is requesting their Progress Report.");
				for (int index = 0; index < temporaryRecords.size(); index++) {
					if (userId.equals(temporaryRecords.get(index).getStudent().getId())) {
						stuProg.setStudent(temporaryRecords.get(index).getStudent());
						stuProg.setDepartment(temporaryRecords.get(index).getDepartment());
						stuProg.setTermBegan(temporaryRecords.get(index).getTermBegan());
						stuProg.setDegreeSought(temporaryRecords.get(index).getDegreeSought());
						stuProg.setCertificateSought(temporaryRecords.get(index).getCertificateSought());
						stuProg.setAdvisors(temporaryRecords.get(index).getAdvisors());
						stuProg.setCommittee(temporaryRecords.get(index).getCommittee());
						stuProg.setRequirementCheckResults(temporaryRecords.get(index));

					}
				}
			}

			// CS GPC is requesting one of their CS student's SR
			if (!activeUser_.getId().equals(inputUser.getId())
					&& activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")
					&& activeUser_.getDepartment().equals(inputUser.getDepartment())) {
				System.out.println(
						"GPC " + activeUser_.getId() + " is requesting " + inputUser.getId() + "'s Progress Report.");
				for (int index = 0; index < temporaryRecords.size(); index++) {
					if (userId.equals(temporaryRecords.get(index).getStudent().getId())) {
						stuProg.setStudent(temporaryRecords.get(index).getStudent());
						stuProg.setDepartment(temporaryRecords.get(index).getDepartment());
						stuProg.setTermBegan(temporaryRecords.get(index).getTermBegan());
						stuProg.setDegreeSought(temporaryRecords.get(index).getDegreeSought());
						stuProg.setCertificateSought(temporaryRecords.get(index).getCertificateSought());
						stuProg.setAdvisors(temporaryRecords.get(index).getAdvisors());
						stuProg.setCommittee(temporaryRecords.get(index).getCommittee());
						stuProg.setRequirementCheckResults(temporaryRecords.get(index));
					}
				}
			}

			return stuProg;
		} catch (Exception e) {

			System.out.println("Error in generating progress summary: " + e.getMessage());

			return null;
		}

	}

	/**
	 * Generates a new progress summary, assuming that the student passes the
	 * provided set of prospective courses.
	 * 
	 * @param userId
	 *            the student to generate the record for.
	 * @param courses
	 *            a list of the prospective courses.
	 * @returns the student's hypothetical progress summary
	 * @throws Exception
	 *             if the progress summary could not be generated or the courses
	 *             are invalid. SEE NOTE IN CLASS HEADER.
	 */
	public ProgressSummary simulateCourses(String userId, List<CourseTaken> courses) throws Exception {

		try {
			// get the student record
			StudentRecord rec = getTranscript(userId);
			boolean simulate = false;

			// user is a gpc
			if (activeUser_ != null && activeUser_.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")
					&& activeUser_.getDepartment().equals("COMPUTER_SCIENCE")
					&& rec.getDepartment().equals("COMPUTER_SCIENCE")) {
				// find the student record
				simulate = true;
			}
			// user is requesting his student record
			else if (rec != null && activeUser_ != null && rec.getStudent().getId().equals(activeUser_.getId())) {
				simulate = true;
			}

			if (simulate) {
				int recordIndex = -1;

				// find the student record
				for (int index = 0; index < records.size(); index++) // find the
																		// record
				{
					if (records.get(index) != null && records.get(index).getStudent().getId().equals(userId)) {
						recordIndex = index;
						break;
					} else if (index == records.size()) {
						System.out.println("Student Record doesn't exist");
					}
				}

				if (recordIndex != -1) {
					temporaryRecords.get(recordIndex).setCoursesTaken(courses);
				}

				return generateProgressSummary(userId);
			}
			// return a null progress report
			else {
				System.out.print("Unable to simulate courses");

				return null;
			}
		} catch (Exception e) {

			System.out.println("Error in simulate courses: " + e.getMessage());

			return null;
		}

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

	public List<StudentRecord> getTemporaryRecords() {
		return temporaryRecords;
	}

	public void setTemporaryRecords(List<StudentRecord> temporaryRecords) {
		this.temporaryRecords = temporaryRecords;
	}
	
	public boolean getUpdateTranscriptFailed() {
		return this.updateTranscriptFailed;
	}
	
	public boolean getAddNoteFailed() {
		return this.updateNoteFailed;
	}

}