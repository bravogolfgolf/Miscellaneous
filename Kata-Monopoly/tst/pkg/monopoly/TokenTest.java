package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TokenTest {

    private Token token1;
    private Token token2;

    @Before
    public void setup(){
        token1 = new Token("Boot");
        token2 = new Token("Boot");
    }

    @Test
    public void testCreateToken() {
        final int EXPECTED_INITIAL_LOCATION = 0;
        assertEquals("Boot", token1.getDescription());
        assertEquals(EXPECTED_INITIAL_LOCATION, token1.getLocation());
    }

    @Test
    public void testSetLocation(){
        token1.setLocation(39);
        assertEquals(39,token1.getLocation());
    }

    @Test
    public void testTokenEqualityAndHashcode() {
        assertTrue(token1.equals(token2));
        assertTrue(token1.hashCode() == token2.hashCode());
    }
}
