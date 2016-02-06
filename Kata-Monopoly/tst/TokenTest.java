import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenTest {

    private Token tokenCat;

    @Before
    public void setup() {
        tokenCat = new Token("Cat");
    }

    @Test
    public void testCreateToken() {
        final int EXPECTED_INITIAL_LOCATION = 0;
        assertEquals(EXPECTED_INITIAL_LOCATION, tokenCat.getLocation());
        assertEquals("Cat", tokenCat.getTokenDescription());
    }

    @Test
    public void testTokenMovesNoWrap() {
        int startingProperty = tokenCat.getLocation();
        int number = tokenCat.roll();
        int endingProperty = number + startingProperty;
        assertEquals(endingProperty, tokenCat.getLocation());
    }

    @Test
    public void testTokenMovesAndWraps() {
        int startingProperty = Board.LAST_LOCATION_ON_BOARD;
        tokenCat.setLocation(startingProperty);
        int number = tokenCat.roll();
        assertTrue(String.format("Location: %d; Number: %d; Result: %d", startingProperty, number, tokenCat.getLocation()),
                tokenCat.getLocation() < Board.LAST_LOCATION_ON_BOARD);
    }
}
