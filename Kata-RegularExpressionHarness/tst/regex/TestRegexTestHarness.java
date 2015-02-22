package regex;

import org.junit.Test;

public class TestRegexTestHarness {

	@Test
	public void testFindSingleCharater() {
		String regex = "a";
		String input = "bat cat rat sat";
		regex(regex,input);
	}

	@Test
	public void testFindAllWithLeadingCharater() {
		String regex = ".at";
		String input = "bat cat rat sat borat";
		regex(regex,input);
	}

	@Test
	public void testFindWithCertainLeadingCharaters() {
		String regex = "[r]at";
		String input = "bat cat rat sat borat";
		regex(regex,input);
	}

	@Test
	public void testFindWithoutCertainLeadingCharaters() {
		String regex = "[^r]at";
		String input = "bat cat rat sat borat";
		regex(regex,input);
	}

	@Test
	public void testFindCharaterRange() {
		String regex = "[r-s]";
		String input = "bat cat rat sat borat";
		regex(regex,input);
	}

	@Test
	public void testFindUnion() {
		String regex = "[a-c[r-s]]at";
		String input = "aat bat cat dat rat sat borat";
		regex(regex,input);
	}

	@Test
	public void testFindIntersection() {
		String regex = "[a-z&&[q-s]]at";
		String input = "aat bat qat cat dat rat sat borat";
		regex(regex,input);
	}

	@Test
	public void testFindIntersectionNegation() {
		String regex = "[a-z&&[^q-s]]at";
		String input = "aat bat qat zat dat rat sat borat";
		regex(regex,input);
	}
	@Test
	public void testFindNonNumeric() {
		String regex = "[\\D+&&[^-]]";
		String input = "//[***]\n1,2,-3";
		regex(regex,input);
	}

	@Test
	public void testFindNonNumericExceptNegativeSign() {
		String regex = "\\D+";
		String input = "//[***]\n1,2,-3";
		regex(regex,input);
	}
	
	@Test
	public void testGreedy() {
		String regex = ".*foo";
		String input = "xfooxxxxxxfoo";
		regex(regex,input);
	}

	@Test
	public void testReluctant() {
		String regex = ".*?foo";
		String input = "xfooxxxxxxfoo";
		regex(regex,input);
	}
	
	@Test
	public void testPossessive() {
		String regex = ".*+foo";
		String input = "xfooxxxxxxfoo";
		regex(regex,input);
	}

	private void regex(String regex, String input) {
		System.out.println(regex +"\t"+input);
		RegexTestHarness.main(regex,input);
		System.out.println("\n");
	}
}
