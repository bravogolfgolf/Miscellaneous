package sis.studentinfo;

import junit.framework.TestCase;
import java.util.*;

public class CourseSessionTest extends TestCase {
	private static int CREDITS = 3;
	private CourseSession session;
	private Date startDate;

	public void setUp() {
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createCourseSession();
	}

	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}

	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(CREDITS,student1.getCredits());

		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
		assertEquals(CREDITS,student1.getCredits());
		assertEquals(CREDITS,student2.getCredits());
	}

	public void testCourseDates() {
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}

	public void testCount(){
		CourseSession.resetCount();
		assertEquals(0,CourseSession.getCount());
		createCourseSession();
		assertEquals(1,CourseSession.getCount());
		createCourseSession();
		assertEquals(2,CourseSession.getCount());
	}
	CourseSession createCourseSession(){
		CourseSession session = CourseSession.create("ENGL", "101", startDate);
		session.setNumberOfCredits(CourseSessionTest.CREDITS);
		return session;
	}
}