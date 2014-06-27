package sis.db;

import java.io.*;

import junit.framework.*;

public class DataFileTest extends TestCase {
	private static final String ID1 = "12345";
	private static final String ID2 = "23456";
	private static final String FILEBASE = "DataFileTest";

	private DataFile db;
	private TestData testData1;
	private TestData testData2;

	protected void setUp() throws Exception{
		db = DataFile.create(FILEBASE);
		assertEquals(0,db.size());

		testData1 = new TestData(ID1, "daum1a", 1);
		testData1 = new TestData(ID2, "daum2a", 2);
	}

	protected void tearDown() {
		db.close();
		db.deleteFiles();
	}

	public void testAdd() throws IOException {
		db.add(ID1, testData1);
		assertEquals(1,db.size());
		
		db.add(ID2, testData2);
		assertEquals(2,db.size());
	
		assertEquals(testData1,db.findBy(ID1));
		assertEquals(testData2,db.findBy(ID2));
	}

	@SuppressWarnings("serial")
	static class TestData implements Serializable {
		private String id;
		private String field1;
		private int field2;
		TestData(String id, String field1, int field2){
			this.id = id;
			this.field1 = field1;
			this.field2 = field2;
		}
	}
}
