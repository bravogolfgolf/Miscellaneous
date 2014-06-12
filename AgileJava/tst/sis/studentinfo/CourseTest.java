package sis.studentinfo;

import junit.framework.*;

public class CourseTest extends TestCase {

	public void testCreate() {
		Course course = new Course("ENGL","101");
		assertEquals("ENGL", course.getDepartment());
		assertEquals("101", course.getNumber());
	}
	public void testEquality(){
		Course courseA = new Course("ENGL","101");
		Course courseAPrime = new Course("ENGL","101");
		assertEquals(courseA, courseAPrime);

		Course courseB = new Course("ENGL","201");
		assertFalse(courseA.equals(courseB));
		assertFalse(courseA.equals("ENGL-201"));
		
		//reflexivity
		assertEquals(courseA, courseA);
		
		//transitivity
		Course courseAPrime2 = new Course("ENGL","101");
		assertEquals(courseAPrime, courseAPrime2);
		assertEquals(courseA, courseAPrime2);
	
		//symmetry
		assertEquals(courseAPrime,courseA);
		
		//consistency
		assertEquals(courseA, courseAPrime);
		
		//comparison to null
		assertFalse(courseA.equals(null));
	}
}