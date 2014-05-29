package sis.summer;

import java.util.*;
import sis.studentinfo.*;

public class SummerCourseSessionTest extends SessionTest {

	public void testEndDate(){
		Date startDate = DateUtil.createDate(2014, 6, 2);
		Session course = createSession("ENGL", "101", startDate);
		Date eightWeeksOut = DateUtil.createDate(2014, 7, 25);
		assertEquals(eightWeeksOut,course.getEndDate());
	}

	@Override
	protected Session createSession(String department, String number, Date date) {
		return SummerCourseSession.create(department, number, date);
	}
}