package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    @Test
    public void testTokensCreated() {
        assertEquals("Cat", Token.Cat.toString());
        assertEquals("(C)at", Token.Cat.getMenuString());

        assertEquals("Dog", Token.Dog.toString());
        assertEquals("(D)og", Token.Dog.getMenuString());

        assertEquals("Racecar", Token.Racecar.toString());
        assertEquals("(R)acecar", Token.Racecar.getMenuString());

        assertEquals("Cat", Token.Cat.toString());
        assertEquals("(C)at", Token.Cat.getMenuString());

        assertEquals("Cat", Token.Cat.toString());
        assertEquals("(C)at", Token.Cat.getMenuString());

        assertEquals("Cat", Token.Cat.toString());
        assertEquals("(C)at", Token.Cat.getMenuString());

        assertEquals("Cat", Token.Cat.toString());
        assertEquals("(C)at", Token.Cat.getMenuString());

        assertEquals("Cat", Token.Cat.toString());
        assertEquals("(C)at", Token.Cat.getMenuString());
    }

}
