package marsRover;

public enum Instruction {
	R(1),
	L(2),
	F(3),
	B(4);

	private final int value;

	private Instruction(final int newValue) {
		value = newValue;
	}

	public int getValue() {return value;}
	
}