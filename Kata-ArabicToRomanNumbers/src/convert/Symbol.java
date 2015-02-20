package convert;

public enum Symbol {
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

	private final int value;

	private Symbol(final int newValue) {
		value = newValue;
	}

	public int getValue() { return value; }
}
