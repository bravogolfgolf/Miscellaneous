package sis.studentinfo;

import junit.framework.*;

public class StudentTest extends TestCase {
	private static final double GRADE_TOLERANCE = 0.05;

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
	public void testCalculateGpa(){
		Student student  = createStudent("TestGrade");
		assertEquals(0.0,student.getGradePointAverage(),GRADE_TOLERANCE);
		student.addGrade(Student.Grade.A);
		assertEquals(4.0,student.getGradePointAverage(),GRADE_TOLERANCE);
		student.addGrade(Student.Grade.B);
		assertEquals(3.5,student.getGradePointAverage(),GRADE_TOLERANCE);
		student.addGrade(Student.Grade.C);
		assertEquals(3.0,student.getGradePointAverage(),GRADE_TOLERANCE);
		student.addGrade(Student.Grade.D);
		assertEquals(2.5,student.getGradePointAverage(),GRADE_TOLERANCE);
		student.addGrade(Student.Grade.F);
		assertEquals(2.0,student.getGradePointAverage(),GRADE_TOLERANCE);
	}
	public void testHonorStudent(){
		Student honorStudent = createStudent("HonorStudent");
		assertEquals(RegularGradeStrategy.class, honorStudent.getGradeStrategy().getClass());
		HonorGradeStrategy honorGradeStrategy = new HonorGradeStrategy();
		honorStudent.setGradeStrategy(honorGradeStrategy);
		assertTrue(honorStudent.getGradeStrategy().equals(honorGradeStrategy));
	}
	public void testCalculateHonorGpa(){
		Student honorStudent = createHonorStudent("TestHonorGrade");
		assertEquals(0.0,honorStudent.getGradePointAverage(),GRADE_TOLERANCE);
		honorStudent.addGrade(Student.Grade.A);
		assertEquals(5.0,honorStudent.getGradePointAverage(),GRADE_TOLERANCE);
		honorStudent.addGrade(Student.Grade.B);
		assertEquals(4.5,honorStudent.getGradePointAverage(),GRADE_TOLERANCE);
		honorStudent.addGrade(Student.Grade.C);
		assertEquals(4.0,honorStudent.getGradePointAverage(),GRADE_TOLERANCE);
		honorStudent.addGrade(Student.Grade.D);
		assertEquals(3.5,honorStudent.getGradePointAverage(),GRADE_TOLERANCE);
		honorStudent.addGrade(Student.Grade.F);
		assertEquals(2.8,honorStudent.getGradePointAverage(),GRADE_TOLERANCE);
	}

	Student createHonorStudent(String name){
		Student honorStudent = new Student(name);
		honorStudent.setGradeStrategy(new HonorGradeStrategy());
		return honorStudent;
	}
	Student createStudent(String name){
		return new Student(name);
	}
}
