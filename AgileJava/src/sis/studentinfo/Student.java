package sis.studentinfo;

public class Student {
	static String IN_STATE = "CO";
	static int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	private String name;
	private int credits;
	private String state = "";

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
}