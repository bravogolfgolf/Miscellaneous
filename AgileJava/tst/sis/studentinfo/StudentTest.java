package sis.studentinfo;

import junit.framework.*;

public class StudentTest extends TestCase {
	public void testCreate() {
		final String firstStudentName = "First";
		Student firstStudent = createStudent(firstStudentName);
		assertEquals(firstStudentName, firstStudent.getName());

		final String secondStudentName = "Second";
		Student secondStudent = createStudent(secondStudentName);
		assertEquals(secondStudentName, secondStudent.getName());
	}
	public void testStudentStatus(){
		Student student  = createStudent("Status");
		assertEquals(0,student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3,student.getCredits());
		assertFalse(student.isFullTime());

		student.addCredits(4);
		assertEquals(7,student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME,student.getCredits());
		assertTrue(student.isFullTime());
	}
	public void testInState(){
		Student student  = createStudent("InState");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("VA");
		assertFalse(student.isInState());	
	}
	Student createStudent(String name){
		return new Student(name);
	}
}