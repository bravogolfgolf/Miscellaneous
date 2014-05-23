package sis.summer;

import java.util.*;
import sis.studentinfo.*;
import junit.framework.*;

public class SummerSessionTest extends TestCase {
	public void testEndDate(){
		Date startDate = DateUtil.createDate(2014, 6, 2);
		CourseSession course = SummerCourseSession.create("ENGL", "101", startDate);
		Date eightWeeksOut = DateUtil.createDate(2014, 7, 25);
		assertEquals(eightWeeksOut,course.getEndDate());
	}
}
