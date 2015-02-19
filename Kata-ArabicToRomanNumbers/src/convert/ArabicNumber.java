package convert;

public class ArabicNumber {
	private enum Symbols {
		M(1000),
		CM(900),
		D(500),
		CD(400),
		C(100),
		XC(90),
		L(50),
		XL(40),
		X(10),
		IX(9),
		V(5),
		IV(4),
		I(1);

		private int arabic;
		private Symbols (int arabic){
			this.arabic = arabic;
		}
	}
	public static String toRoman(int number) {
		String result = "";
		for (Symbols symbol : Symbols.values()) {
			while(number >= symbol.arabic){
				return result = symbol.toString() + toRoman(number - symbol.arabic);
			}
		}
		return result;
	}
}