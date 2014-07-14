package sis.util;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class IOUtilTest extends TestCase {

	static final String FILENAME1 = "IOUtilTest1.txt";
	static final String FILENAME2 = "IOUtilTest2.txt";

	public void testDeleteSingleFile() throws IOException {
		create(FILENAME1);

		assertTrue(IOUtil.delete(FILENAME1));
		TestUtil.assertGone(FILENAME1);
	}

	public void testDeleteMultipleFiles() throws IOException {
		create(FILENAME1,FILENAME2);
		assertTrue(IOUtil.delete(FILENAME1,FILENAME2));
		TestUtil.assertGone(FILENAME1,FILENAME2);
	}

	public void testDeleteNoFile() {
		TestUtil.delete(FILENAME1);
		assertFalse(IOUtil.delete(FILENAME1));
	}

	public void testDeletePartiallySuccessful() throws IOException {
		create(FILENAME1);
		TestUtil.delete(FILENAME2);
		assertFalse(IOUtil.delete(FILENAME1,FILENAME2));
		TestUtil.assertGone(FILENAME1);
	}
	
	private void create(String...filenames) throws IOException {
		for (String filename : filenames) {
			TestUtil.delete(filename);
			new File(filename).createNewFile();
		}
	}
}
