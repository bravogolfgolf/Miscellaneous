package rover;

public enum Compass {
	N(0),
	E(90),
	S(180),
	W(270);

	private final int value;

	private Compass(final int newValue) {
		value = newValue;
	}

	public int getValue() {return value;}

}
