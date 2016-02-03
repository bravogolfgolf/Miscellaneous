package videostore;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VideoStoreTest {

	private Customer customer;

	@Before
	public void setUp ()  {
		customer = new Customer ("Fred");
	}

	@Test
	public void testSingleNewReleaseStatementTotals() {
		customer.addRental(new Rental (new Movie ("The Cell", Movie.NEW_RELEASE), 3)); 
		customer.statement();
		assertEquals(9.0, customer.getTotal(),.001);
		assertEquals(2, customer.getFrequentRenterPoints());
	}

	@Test
	public void testDualNewReleaseStatementTotals() {
		customer.addRental (new Rental (new Movie ("The Cell", Movie.NEW_RELEASE), 3));
		customer.addRental (new Rental (new Movie ("The Tigger Movie", Movie.NEW_RELEASE), 3));		
		customer.statement();
		assertEquals(18.0, customer.getTotal(),.001);
		assertEquals(4, customer.getFrequentRenterPoints());
	}

	@Test
	public void testSingleChildrensStatementTotals() {
		customer.addRental (new Rental (new Movie ("The Tigger Movie", Movie.CHILDRENS), 3));
		customer.statement();
		assertEquals(1.5, customer.getTotal(),.001);
		assertEquals(1, customer.getFrequentRenterPoints());
	}

	@Test
	public void testMultipleRegularStatementTotals() {
		customer.addRental (new Rental (new Movie ("Plan 9 from Outer Space", Movie.REGULAR), 1));
		customer.addRental (new Rental (new Movie ("8 1/2", Movie.REGULAR), 2));
		customer.addRental (new Rental (new Movie ("Eraserhead", Movie.REGULAR), 3));		
		customer.statement();
		assertEquals(7.5, customer.getTotal(),.001);
		assertEquals(3, customer.getFrequentRenterPoints());
	}
	
	@Test
	public void testMultipleRegularStatementOutput() {
		customer.addRental (new Rental (new Movie ("Plan 9 from Outer Space", Movie.REGULAR), 1));
		customer.addRental (new Rental (new Movie ("8 1/2", Movie.REGULAR), 2));
		customer.addRental (new Rental (new Movie ("Eraserhead", Movie.REGULAR), 3));		
		assertEquals ("Rental Record for Fred\n"
				+ "\tPlan 9 from Outer Space\t2.0\n"
				+ "\t8 1/2\t2.0\n"
				+ "\tEraserhead\t3.5\n"
				+ "You owed 7.5\n"
				+ "You earned 3 frequent renter points\n", 
				customer.statement ());
	}
}