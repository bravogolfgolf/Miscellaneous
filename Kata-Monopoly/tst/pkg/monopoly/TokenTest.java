package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    @Test
    public void testCreateToken() {
        final int EXPECTED_INITIAL_LOCATION = 0;
        Token token = new Token(MenuItems.Boot.getDescription());
        assertEquals("Boot", token.getDescription());
        assertEquals(EXPECTED_INITIAL_LOCATION, token.getLocation());
    }

}
