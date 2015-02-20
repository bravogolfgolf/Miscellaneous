package convert;

public class Arabic {

	public static String convert(int input) {
		String roman = "";
		for (Symbol symbol : Symbol.values()) {
			for(;input >= symbol.getValue(); input-=symbol.getValue()){
				roman += symbol;
			}
		}	 
		return roman;
	}
}