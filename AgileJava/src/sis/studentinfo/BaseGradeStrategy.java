package sis.studentinfo;

public  class BaseGradeStrategy implements GradeStrategy {
	public double getPointsForGrade(Student.Grade grade){
		return grade.getPoints();
	}
}
