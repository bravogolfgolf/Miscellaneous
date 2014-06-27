package sis.studentinfo;

import java.io.*;

import junit.framework.*;

public class StudentDirectoryTest extends TestCase {
	private StudentDirectory dir;
	protected void setUp() throws IOException {
		dir = new StudentDirectory();
	}

	protected void tearDown() throws IOException {
		dir.close();
		dir.remove();
	}

	public void testRandomAccess() throws IOException{
		final int numberOfStudents = 10;
		for(int i = 0; i < numberOfStudents; i++){
			addStudent(dir, i);
		}
		dir.close();
		dir = new StudentDirectory();
		for(int i = 0; i < numberOfStudents; i++){
			verifyStudent(dir, i);
		}
	}

	private void addStudent(StudentDirectory directroy, int i) throws IOException {
		String id = "" + i;
		Student student = new Student(id);
		student.setId(id);
		student.addCredits(i);
		directroy.add(student);
	}
	private void verifyStudent(StudentDirectory directroy, int i) throws IOException {
		String id = "" + i;
		Student student = (Student)directroy.findbyId(id);
		assertEquals(id,student.getLastName());
		assertEquals(id,student.getId());
		assertEquals(i,student.getCredits());
	}
}