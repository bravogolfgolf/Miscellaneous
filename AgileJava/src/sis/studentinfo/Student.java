package sis.studentinfo;

import java.util.*;

public class Student {
	public enum Grade {A, B, C, D, F}
	static String IN_STATE = "CO";
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	private String name;
	private int credits = 0;
	private String state = "";
	private List<Student.Grade> grades = new ArrayList<Student.Grade>();
	GradeStrategy gradeStrategy = new BaseGradeStrategy();

	public Student(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	boolean isFullTime(){
		return getCredits() >= CREDITS_REQUIRED_FOR_FULL_TIME; 
	}
	void addCredits(int credits){
		this.credits += credits;
	}
	int getCredits(){
		return credits;
	}
	void setState(String state){
		this.state = state;
	}
	boolean isInState(){
		return state.equals(Student.IN_STATE);
	}
	double getGradePointAverage() {
		if (grades.isEmpty()) {
			return 0.0;
		}
		double numerator = 0.0;
		for(Grade grade : grades) {
			numerator += gradeStrategy.getPointsForGrade(grade);
		}
		return numerator / grades.size();
	}
	void addGrade(Grade grade) {
		grades.add(grade);
	}
	void setGradeStrategy(GradeStrategy gradeStrategy) {
		this.gradeStrategy = gradeStrategy;
	}
	GradeStrategy getGradeStrategy() {
		return gradeStrategy;
	}
}