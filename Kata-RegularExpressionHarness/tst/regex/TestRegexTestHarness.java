package regex;

import org.junit.Test;

public class TestRegexTestHarness {
	//		String NEW_LINE = System.getProperty("line.separator");

/*	@Test
	public void testFindSingleCharater() {
		String regex = "a";
		String input = "bat cat rat sat";
		RegexTestHarness.main(regex,input);
	}

	@Test
	public void testFindAllWithLeadingCharater() {
		String regex = ".at";
		String input = "bat cat rat sat borat";
		RegexTestHarness.main(regex,input);
	}
	
	@Test
	public void testFindWithCertainLeadingCharaters() {
		String regex = "[r]at";
		String input = "bat cat rat sat borat";
		RegexTestHarness.main(regex,input);
	}
	
	@Test
	public void testFindWithoutCertainLeadingCharaters() {
		String regex = "[^r]at";
		String input = "bat cat rat sat borat";
		RegexTestHarness.main(regex,input);
	}

	@Test
	public void testFindCharaterRange() {
		String regex = "[r-s]";
		String input = "bat cat rat sat borat";
		RegexTestHarness.main(regex,input);
	}
	
	@Test
	public void testFindUnion() {
		String regex = "[a-c[r-s]]at";
		String input = "aat bat cat dat rat sat borat";
		RegexTestHarness.main(regex,input);
	}
	
	@Test
	public void testFindIntersection() {
		String regex = "[a-z&&[q-s]]at";
		String input = "aat bat qat cat dat rat sat borat";
		RegexTestHarness.main(regex,input);
	}
	
	@Test
	public void testFindIntersectionNegation() {
		String regex = "[a-z&&[^q-s]]at";
		String input = "aat bat qat zat dat rat sat borat";
		RegexTestHarness.main(regex,input);
	}
*/	@Test
	public void testFindNonNumeric() {
		String regex = "[\\D+&&[^-]]";
		String input = "//[***]\n1,2,-3";
		RegexTestHarness.main(regex,input);
	}
	
	@Test
	public void testFindNonNumericExceptNegativeSign() {
		String regex = "\\D+";
		String input = "//[***]\n1,2,-3";
		RegexTestHarness.main(regex,input);
	}
	
}
