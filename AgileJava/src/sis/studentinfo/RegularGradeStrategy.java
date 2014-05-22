package sis.studentinfo;

public class RegularGradeStrategy implements GradeStrategy {
	static final double  GRADE_A = 4.0, GRADE_B = 3.0, GRADE_C = 2.0, GRADE_D = 1.0;
	public double getPointsForGrade(Student.Grade grade){
		if (grade == Student.Grade.A) return RegularGradeStrategy.GRADE_A;
		if (grade == Student.Grade.B) return RegularGradeStrategy.GRADE_B;
		if (grade == Student.Grade.C) return RegularGradeStrategy.GRADE_C;
		if (grade == Student.Grade.D) return RegularGradeStrategy.GRADE_D;
		return 0.0;
	}
}
