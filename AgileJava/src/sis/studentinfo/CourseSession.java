package sis.studentinfo;

import java.util.*;

public class CourseSession extends Session {
	private static int count;
	public static final long serialVersionUID = 11L;

	public static CourseSession create(Course course, Date startDate) {
		return new CourseSession(course , startDate);
	}

	protected CourseSession(Course course, Date startDate){
		super(course, startDate);
		CourseSession.incrementCount();
	}
	static int getCount(){
		return count;
	}
	static void resetCount(){
		count = 0;
	}
	static void incrementCount(){
		count++;
	}
	@Override
	protected int getSessionLength(){
		return 16;
	}
}