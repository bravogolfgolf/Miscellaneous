package sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

abstract public class Session implements Comparable<Session> {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;

	protected Session(String department, String number, Date startDate){
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	public int compareTo(Session that) {
		if (this.getDepartment().compareTo(that.getDepartment()) == 0){
			return this.getNumber().compareTo(that.getNumber());
		}
		return this.getDepartment().compareTo(that.getDepartment());
	}

	void setNumberOfCredits(int numberOfCredits){
		this.numberOfCredits = numberOfCredits;
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
		student.addCredits(numberOfCredits);
		students.add(student);

	}

	Student get(int index) {
		return students.get(index);
	}

	protected Date getStartDate() {
		return startDate;
	}

	public List<Student> getAllStudents() {
		return students;
	}
	abstract protected int getSessionLength();

	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

}
