package sis.report;

import java.io.*;

import junit.framework.*;
import sis.report.RosterReport;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class RosterReportTest extends TestCase {
	private Session session;
	protected void setUp(){
		session =
				CourseSession.create(new Course("ENGL", "101"), DateUtil.createDate(2003, 1, 6));
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
	}

	public void testRosterReport() throws IOException {
		Writer writer = new StringWriter();	
		new RosterReport(session).writeReport(writer);
		assertReportContents(writer.toString());
	}

	public void testFiledReport() throws IOException {
		final String fileName = "TestFile.txt";

		try{
			delete(fileName);
			new RosterReport(session).writeReport(fileName);

			StringBuffer buffer = new StringBuffer();
			String line;

			BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
			while ((line = reader.readLine()) != null)
				buffer.append(String.format(line + "%n"));
			assertReportContents(buffer.toString());
			reader.close();
		}
		finally{
			delete(fileName);			
		}
	}

	private void delete(String fileName) {
		File file = new File(fileName);
		if (file.exists()){
			assertTrue("unable to delete " + fileName, file.delete());
		}		
	}

	private void assertReportContents(String rosterReport){
		assertEquals(
				RosterReport.ROSTER_REPORT_HEADER +
				"A" + NEWLINE +
				"B" + NEWLINE +
				RosterReport.ROSTER_REPORT_FOOTER + "2" +
				NEWLINE, rosterReport);
	}

}