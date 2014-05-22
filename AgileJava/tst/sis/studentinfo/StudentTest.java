package sis.studentinfo;

import junit.framework.*;

public class StudentTest extends TestCase {
	public void testCreate() {
		final String firstStudentName = "Jane Doe";
		Student firstStudent = createStudent(firstStudentName);
		assertEquals(firstStudentName, firstStudent.getName());

		final String secondStudentName = "Joe Blow";
		Student secondStudent = createStudent(secondStudentName);
		assertEquals(secondStudentName, secondStudent.getName());
	}
	public void testStudentStatus(){
		Student student  = createStudent("Brian Gibson");
		assertFalse(student.isFullTime());
		assertEquals(0,student.getCredits());
		
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
	Student createStudent(String name){
		return new Student(name);
	}
}