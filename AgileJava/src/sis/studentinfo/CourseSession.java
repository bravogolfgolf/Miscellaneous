package sis.studentinfo;

import java.util.*;

/**
 * This class provides a representation of a single-semester
 * session of a specific university course.
 * @author Administrator
 */
public class CourseSession implements Comparable<CourseSession> {
	private static int count;
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;

	private CourseSession(String department, String number, Date startDate){
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	public static CourseSession create(String department, String number, Date startDate) {
		incrementCount();
		return new CourseSession(department, number, startDate);
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	int getNumberOfStudents() {
		return students.size();
	}

	public void enroll(Student student) {
		students.add(student);
		student.addCredits(numberOfCredits);
	}

	Student get(int index) {
		return students.get(index);
	}

	Date getStartDate() {
		return startDate;
	}

	public List<Student> getAllStudents() {
		return students;
	}

	/**
	 * @return Date the last date of the course session
	 */
	Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		final int sessionLength = 16;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays =
				sessionLength * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}
	void setNumberOfCredits(int numberOfCredits){
		this.numberOfCredits = numberOfCredits;
	}
	static int getCount(){
		return count;
	}
	static void resetCount(){
		count = 0;
	}
	static void incrementCount(){
		count++;
	}
	public int compareTo(CourseSession that) {
		if (this.getDepartment().compareTo(that.getDepartment()) == 0){
			return this.getNumber().compareTo(that.getNumber());
		}
		return this.getDepartment().compareTo(that.getDepartment());
	}
}