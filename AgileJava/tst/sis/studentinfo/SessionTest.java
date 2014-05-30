package sis.studentinfo;


import java.net.MalformedURLException;
import java.util.*;
import junit.framework.*;

abstract public class SessionTest extends TestCase{
	private Session session;
	private Date startDate;
	private static int CREDITS = 3;

	public void setUp() {
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createSession("ENGL","101",startDate);
		session.setNumberOfCredits(CREDITS);
	}

	abstract protected Session createSession(String department, String number, Date date);

	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}

	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(CREDITS,student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));


		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(CREDITS,student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}

	public void testCompareble(){
		Date date = new Date();
		CourseSession sessionA1 = CourseSession.create("ABC", "101", date);
		CourseSession sessionB1 = CourseSession.create("BCD", "101", date);
		assertTrue(sessionA1.compareTo(sessionB1) < 0);
		assertTrue(sessionB1.compareTo(sessionA1) > 0);

		CourseSession sessionA0 = CourseSession.create("ABC", "101", date);
		assertEquals(0,sessionA1.compareTo(sessionA0));

		CourseSession sessionA2 = CourseSession.create("ABC", "201", date);
		assertTrue(sessionA1.compareTo(sessionA2) < 0);
		assertTrue(sessionA2.compareTo(sessionA1) > 0);

	}
	public void testSessionUrl() throws MalformedURLException {
		final String url = "http://www.university.edu/ENGL/101";
		session.setUrl(url);
		assertEquals("http://www.university.edu/ENGL/101",session.getUrl().toString());
	}
	public void testBadSessionUrl(){
		final String url = "bad://url";
		try {
			session.setUrl(url);
			fail("Expected MalformedURLException");
		} catch (MalformedURLException success) {
		}
	}
}
