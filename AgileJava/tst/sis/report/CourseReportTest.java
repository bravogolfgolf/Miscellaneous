package sis.report;

import java.util.*;
import sis.studentinfo.*;
import junit.framework.*;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReportTest extends TestCase{

	public void testReport(){
		final Date date = new Date();
		CourseReport courseReport = new CourseReport();
		courseReport.add(CourseSession.create(new Course("ENGL", "101"), date));
		courseReport.add(CourseSession.create(new Course("CZEC", "200"), date));
		courseReport.add(CourseSession.create(new Course("ITAL", "410"), date));
		courseReport.add(CourseSession.create(new Course("CZEC", "220"), date));
		courseReport.add(CourseSession.create(new Course("ITAL", "330"), date));
		
		assertEquals(
				"CZEC 200" + NEWLINE +
				"CZEC 220" + NEWLINE +
				"ENGL 101" + NEWLINE +
				"ITAL 330" + NEWLINE +
				"ITAL 410" + NEWLINE, courseReport.getReport());
	}
}