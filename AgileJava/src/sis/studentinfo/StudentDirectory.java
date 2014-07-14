package sis.studentinfo;

import java.io.IOException;

import sis.db.*;

public class StudentDirectory{
	private static final String DIR_BASENAME = "studentDir";
	private DataFile db;

	StudentDirectory() throws IOException {
		db = DataFile.open(DIR_BASENAME);
	}

	public void add(Student student) throws IOException {
		db.add(student.getId(),student);	
	}

	public Object findbyId(String id) throws IOException {
		return db.findBy(id);
	}

	public void close() throws IOException {
		db.close();

	}

	public void remove() {
		db.deleteFiles();
	}

}