package sis.studentinfo;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

abstract public class Session implements Comparable<Session>, Serializable {
	private Course course;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;
	private URL url;

	protected Session(Course course, Date startDate){
		this.course = course;
		this.startDate = startDate;
	}

	public int compareTo(Session that) {
		if (this.getCourse().getDepartment().compareTo(that.getCourse().getDepartment()) == 0){
			return this.getCourse().getNumber().compareTo(that.getCourse().getNumber());
		}
		return this.getCourse().getDepartment().compareTo(that.getCourse().getDepartment());
	}

	public Course getCourse() {
		return course;
	}

	void setNumberOfCredits(int numberOfCredits){
		this.numberOfCredits = numberOfCredits;
	}

	int getNumberOfCredits(){
		 return numberOfCredits;
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

	public void setUrl(String url) throws SessionException {
		try {
			this.url = new URL(url);
		}
		catch (MalformedURLException e) {
			log(e);
			throw new SessionException(e);
		}
	}

	private void log(Exception e) {
		//	e.printStackTrace();
		e.getStackTrace();
	}

	public URL getUrl() {
		return url;
	}
}
