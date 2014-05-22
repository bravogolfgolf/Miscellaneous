package sis.studentinfo;

import java.util.ArrayList;

public class Student {
	enum Grade {A, B, C, D, F}
	static String IN_STATE = "CO";
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final double HONOR_SCALER = 1;
	private String name;
	private int credits;
	private String state = "";
	private ArrayList<Student.Grade> grades = new ArrayList<Student.Grade>();
	static final double  GRADE_A = 4.0, GRADE_B = 3.0, GRADE_C = 2.0, GRADE_D = 1.0;
	private boolean isHonor = false;

	public Student(String name) {
		this.name = name;
		this.credits = 0;
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

		if (getHonor() == false){
			for(Grade grade : grades) {
				if (grade == Student.Grade.A) numerator += GRADE_A;
				else if (grade == Student.Grade.B) numerator += GRADE_B;
				else if (grade == Student.Grade.C) numerator += GRADE_C;
				else if (grade == Student.Grade.D) numerator += GRADE_D;
			}
		}
		else if (getHonor() == true){
			for(Grade grade : grades) {
				if (grade == Student.Grade.A) numerator += GRADE_A + HONOR_SCALER;
				else if (grade == Student.Grade.B) numerator += GRADE_B + HONOR_SCALER;
				else if (grade == Student.Grade.C) numerator += GRADE_C + HONOR_SCALER;
				else if (grade == Student.Grade.D) numerator += GRADE_D + HONOR_SCALER;
			}
		}
		return numerator / grades.size();
	}

	void addGrade(Grade grade) {
		grades.add(grade);
	}

	void setHonor() {
		this.isHonor = true;
	}
	boolean getHonor(){
		return this.isHonor;
	}
}