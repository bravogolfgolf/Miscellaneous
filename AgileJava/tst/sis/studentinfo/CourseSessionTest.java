package sis.studentinfo;

import java.util.*;

public class CourseSessionTest extends SessionTest {
	public void testCourseDates() {
		Date startDate = DateUtil.createDate(2003, 1, 6);
		Session session = createSession(new Course("ENGL","101"),startDate);
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}

	public void testCount(){
		CourseSession.resetCount();
		assertEquals(0,CourseSession.getCount());
		createSession(new Course("", ""), new Date());
		assertEquals(1,CourseSession.getCount());
		createSession(new Course("", ""), new Date());
		assertEquals(2,CourseSession.getCount());
	}

	@Override
	protected Session createSession(Course course, Date date) {
		return CourseSession.create(course, date);
	}
}
