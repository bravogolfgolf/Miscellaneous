package tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10),five.times(2));
		assertEquals(Money.dollar(15),five.times(3));
	}

	@Test
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.dollar(5).equals(Money.franc(5)));
	}

	@Test
	public void testName() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}
	
	@Test
	public void testAddition() {
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), reduced);
	}
}
