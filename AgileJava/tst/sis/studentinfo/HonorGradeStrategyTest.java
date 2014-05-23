package sis.studentinfo;

import junit.framework.*;

public class HonorGradeStrategyTest extends TestCase {
	public void testCreate(){
		HonorGradeStrategy honorGradeStrategy = new HonorGradeStrategy();
		assertEquals(5.0,honorGradeStrategy.getPointsForGrade(Student.Grade.A));
		assertEquals(4.0,honorGradeStrategy.getPointsForGrade(Student.Grade.B));
		assertEquals(3.0,honorGradeStrategy.getPointsForGrade(Student.Grade.C));
		assertEquals(2.0,honorGradeStrategy.getPointsForGrade(Student.Grade.D));
		assertEquals(0.0,honorGradeStrategy.getPointsForGrade(Student.Grade.F));
	}
}
