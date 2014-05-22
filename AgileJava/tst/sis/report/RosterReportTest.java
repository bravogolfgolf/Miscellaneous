package sis.report;

import junit.framework.TestCase;
import sis.report.RosterReport;
import sis.studentinfo.*;

public class RosterReportTest extends TestCase {
	public void testRosterReport() {
		CourseSession session =
				CourseSession.create("ENGL", "101", DateUtil.createDate(2003, 1, 6));

		session.enroll(new Student("A"));
		session.enroll(new Student("B"));

		String rosterReport = new RosterReport(session).getReport();
		assertEquals(
				RosterReport.ROSTER_REPORT_HEADER +
				"A" + RosterReport.NEWLINE +
				"B" + RosterReport.NEWLINE +
				RosterReport.ROSTER_REPORT_FOOTER + "2" +
				RosterReport.NEWLINE, rosterReport);
		System.out.println(rosterReport);
	}

}