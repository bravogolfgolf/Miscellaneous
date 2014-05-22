package sis.studentinfo;

public class Student {
	private static int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	private String name;
	private int credits;

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
}