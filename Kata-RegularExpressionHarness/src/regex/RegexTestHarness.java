package regex;

import java.io.PrintStream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

	public static void main(String regex, String input){

		PrintStream console = System.out;

		Pattern pattern = 
				Pattern.compile(regex);

		Matcher matcher = 
				pattern.matcher(input);

		boolean found = false;
		while (matcher.find()) {
			console.format("I found the text" +
					" \"%s\" starting at " +
					"index %d and ending at index %d.%n",
					matcher.group(),
					matcher.start(),
					matcher.end());
			
			found = true;
		}
		console.format("%n");
		
		if(!found){
			console.format("No match found.%n");
			console.format("%n");
		}
	}
}