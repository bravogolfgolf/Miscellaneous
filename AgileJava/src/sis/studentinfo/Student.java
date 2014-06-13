package sis.studentinfo;

import java.util.*;
import java.util.logging.*;

import sis.studentinfo.Student.Flag;

public class Student {
	public enum Grade {
		A(4.0),
		B(3.0),
		C(2.0), 
		D(1.0),
		F(0.0);

		private double points;

		Grade(double points){
			this.points = points;
		}
		public double getPoints(){
			return points;
		}
	}
	public enum Flag{
		ON_CAMPUS(1),
		TAX_EXEMPT(2),
		MINOR(4),
		TROUBLEMAKER(8);

		private int mask;

		Flag(int mask){
			this.mask = mask;
		}
	}
	static final Logger logger = Logger.getLogger(Student.class.getName());
	static String IN_STATE = "CO";
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final int MAXIMUM_NUMBER_OF_NAME_PARTS = 3;
	static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts.";
	private String name;
	private String firstName = "";
	private String middleName = "";
	private String lastName;
	private int credits = 0;
	private String state = "";
	private List<Student.Grade> grades = new ArrayList<Student.Grade>();
	GradeStrategy gradeStrategy = new BaseGradeStrategy();
	private String id;
	private int settings = 0x0;

	public Student(String fullName) {
		this.name = fullName;
		List<String> nameParts = split(fullName);
		if (nameParts.size() > MAXIMUM_NUMBER_OF_NAME_PARTS) {
			String message = String.format(TOO_MANY_NAME_PARTS_MSG, fullName, MAXIMUM_NUMBER_OF_NAME_PARTS);
			logger.info(message);
			throw new StudentNameFormatException(message);
		}
		setName(nameParts);
	}

	private List<String> split(String fullName) {
		List<String> results = new ArrayList<String>();
		for(String name : fullName.split(" ")){
			results.add(name);
		}
		return results;
	}

	private void setName(List<String> nameParts) {
		if (nameParts.size() == 1){
			this.lastName = nameParts.get(0);
		}else
			if(nameParts.size() == 2){
				this.firstName = nameParts.get(0);
				this.lastName = nameParts.get(1);
			}else
				if(nameParts.size() == 3){
					this.firstName = nameParts.get(0);
					this.middleName = nameParts.get(1);
					this.lastName = nameParts.get(2);
				}

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

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(String id) {
		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void set(Flag...flags) {
		for(Flag flag:flags)
			settings = settings | flag.mask;
	}

	public boolean isOn(Flag flag) {
		if((settings & flag.mask) == flag.mask)
			return true;
		return false;
	}

	public boolean isOff(Flag flag) {
		if((settings & flag.mask) != flag.mask)
			return true;
		return false;
	}

	public void unset(Flag...flags) {
		for(Flag flag:flags) 
			settings = settings & ~flag.mask;
	}

}