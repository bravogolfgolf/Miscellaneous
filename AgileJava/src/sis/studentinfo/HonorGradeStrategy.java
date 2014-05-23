package sis.studentinfo;

public class HonorGradeStrategy extends BaseGradeStrategy {
	static final double HONOR_SCALOR = 1.0;
	public double getPointsForGrade(Student.Grade grade){
		double points = super.getPointsForGrade(grade);
		if(points > 0) points += HONOR_SCALOR;
		return  points;
	}
}
