package convert;

public class Arabic {

	public static String convert(int input) {
		String roman = "";
		if (input == 5){
			roman += "V";
			input-=5;			
		}

		if (input == 4){
			roman += "IV";
			input-=4;			
		}

		while (input >= 1) {
			roman += "I";
			input--;			
		}
		return roman;
	}
}
