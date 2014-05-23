package sis.studentinfo;

import junit.framework.*;

public class BaseGradeStrategyTest extends TestCase {
	public void testCreate(){
		BaseGradeStrategy baseGradeStrategy = new BaseGradeStrategy();
		assertEquals(4.0,baseGradeStrategy.getPointsForGrade(Student.Grade.A));
		assertEquals(3.0,baseGradeStrategy.getPointsForGrade(Student.Grade.B));
		assertEquals(2.0,baseGradeStrategy.getPointsForGrade(Student.Grade.C));
		assertEquals(1.0,baseGradeStrategy.getPointsForGrade(Student.Grade.D));
		assertEquals(0.0,baseGradeStrategy.getPointsForGrade(Student.Grade.F));
	}
}
