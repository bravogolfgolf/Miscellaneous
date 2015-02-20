package convert;

public enum Symbol {
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
