package convert;

public class Arabic {

	public static String convert(int input) {
		String roman = "";
		while (input >= 1) {
			roman += "I";
			input--;			
		}
		return roman;
	}
}
