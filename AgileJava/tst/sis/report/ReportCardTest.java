package sis.report;

import sis.studentinfo.Student;
import junit.framework.TestCase;

public class ReportCardTest extends TestCase {
	public void testReportCardMessage(){
		ReportCard reportCard = new ReportCard();
		assertEquals(ReportCard.A_MESSAGE,reportCard.getMessage(Student.Grade.A));
		assertEquals(ReportCard.B_MESSAGE,reportCard.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE,reportCard.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE,reportCard.getMessage(Student.Grade.D));
		assertEquals(ReportCard.F_MESSAGE,reportCard.getMessage(Student.Grade.F));
	}
}
