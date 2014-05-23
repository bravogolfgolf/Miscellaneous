package sis.studentinfo;

public class RegularGradeStrategy implements GradeStrategy {
	static final double  GRADE_A = 4.0, GRADE_B = 3.0, GRADE_C = 2.0, GRADE_D = 1.0;
	public double getPointsForGrade(Student.Grade grade){
		switch (grade){
		case A: return RegularGradeStrategy.GRADE_A;
		case B: return RegularGradeStrategy.GRADE_B;
		case C: return RegularGradeStrategy.GRADE_C;
		case D: return RegularGradeStrategy.GRADE_D;
		default: return 0.0;
		}
	}
}
