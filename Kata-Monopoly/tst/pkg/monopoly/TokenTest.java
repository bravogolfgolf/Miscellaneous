package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {


    @Test
    public void testCreateToken() {
        Token token = new Token(MenuItems.Boot.getDescription());
        assertEquals("Boot", token.getDescription());
    }

}
