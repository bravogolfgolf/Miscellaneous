package sis.studentinfo;

import junit.framework.*;

public class StudentDirectoryTest extends TestCase {
	private StudentDirectory dir;
	protected void setUp(){
		dir = new StudentDirectory();
	}
	public void testStoreAndRetrieve(){
		final int numberOfStudents = 10;

		for(int i = 0; i < numberOfStudents; i++){
			addStudent(dir, i);
		}
		for(int i = 0; i < numberOfStudents; i++){
			verifyStudent(dir, i);
		}
	}
	private void addStudent(StudentDirectory directroy, int i){
		String id = "" + i;
		Student student = new Student(id);
		student.setId(id);
		student.addCredits(i);
		directroy.add(student);
	}
	private void verifyStudent(StudentDirectory directroy, int i){
		String id = "" + i;
		Student student = directroy.findbyId(id);
		assertEquals(id,student.getLastName());
		assertEquals(id,student.getId());
		assertEquals(i,student.getCredits());
		

	}
}