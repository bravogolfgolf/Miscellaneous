package sis.studentinfo;

public class BaseGradeStrategy implements GradeStrategy {
	static final double  GRADE_A = 4.0, GRADE_B = 3.0, GRADE_C = 2.0, GRADE_D = 1.0;
	public double getPointsForGrade(Student.Grade grade){
		switch (grade){
		case A: return BaseGradeStrategy.GRADE_A;
		case B: return BaseGradeStrategy.GRADE_B;
		case C: return BaseGradeStrategy.GRADE_C;
		case D: return BaseGradeStrategy.GRADE_D;
		default: return 0.0;
		}
	}
}
