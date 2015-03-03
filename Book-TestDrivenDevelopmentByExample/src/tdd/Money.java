package tdd;

abstract class Money {

	protected int amount;
	protected String currency;

	abstract Money times(int multiplier);

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Dollar dollar(int amount) {
		return new Dollar(amount, "USD");
	}

	public static Franc franc(int amount) {
		return new Franc(amount, "CHF");
	}
	
	public String currency(){
		return currency;
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount
				&& getClass().equals(money.getClass());
	}	
}
