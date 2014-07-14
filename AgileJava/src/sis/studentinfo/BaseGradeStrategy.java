package sis.studentinfo;

import java.io.Serializable;

public class BaseGradeStrategy implements GradeStrategy, Serializable {
	public double getPointsForGrade(Student.Grade grade){
		return grade.getPoints();
	}
}
