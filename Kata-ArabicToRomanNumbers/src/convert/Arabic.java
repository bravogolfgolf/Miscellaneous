package convert;

public class Arabic {

	public static String convert(int input) {
		String roman = "";
		while (input >= Symbol.V.getValue()){
			roman += Symbol.V;
			input-=Symbol.V.getValue();			
		}

		while (input >= Symbol.IV.getValue()){
			roman += Symbol.IV;
			input-=Symbol.IV.getValue();			
		}

		while (input >= Symbol.I.getValue()) {
			roman += Symbol.I;
			input-=Symbol.I.getValue();			
		}
		return roman;
	}
}
