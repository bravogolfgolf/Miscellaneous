package sis.studentinfo;

public class HonorGradeStrategy implements GradeStrategy {
	static final double HONOR_SCALOR = 1.0;
	
	public double getPointsForGrade(Student.Grade grade){
		if (grade == Student.Grade.A) return RegularGradeStrategy.GRADE_A + HONOR_SCALOR;
		if (grade == Student.Grade.B) return RegularGradeStrategy.GRADE_B + HONOR_SCALOR;
		if (grade == Student.Grade.C) return RegularGradeStrategy.GRADE_C + HONOR_SCALOR;
		if (grade == Student.Grade.D) return RegularGradeStrategy.GRADE_D + HONOR_SCALOR;
		return 0.0;
	}
}
