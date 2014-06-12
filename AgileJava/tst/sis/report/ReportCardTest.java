package sis.report;

import java.util.*;
import sis.studentinfo.Student;
import junit.framework.*;

public class ReportCardTest extends TestCase {
	private ReportCard reportCard;

	protected void setUp(){
		reportCard = new ReportCard();	
	}

	public void testReportCardMessage(){
		assertEquals(ReportCard.A_MESSAGE,reportCard.getMessage(Student.Grade.A));
		assertEquals(ReportCard.B_MESSAGE,reportCard.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE,reportCard.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE,reportCard.getMessage(Student.Grade.D));
		assertEquals(ReportCard.F_MESSAGE,reportCard.getMessage(Student.Grade.F));
	}

	public void testKeys(){
		Set<Student.Grade> expectedGrades = new HashSet<Student.Grade>();
		expectedGrades.add(Student.Grade.A);
		expectedGrades.add(Student.Grade.B);
		expectedGrades.add(Student.Grade.C);
		expectedGrades.add(Student.Grade.D);
		expectedGrades.add(Student.Grade.F);
		
		Set<Student.Grade> grades = new HashSet<Student.Grade>();
		for (Student.Grade grade : reportCard.getMessages().keySet()){
			grades.add(grade);
		}
		assertEquals(expectedGrades,grades);
	}
}
