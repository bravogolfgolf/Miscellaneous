package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    @Test
    public void testTokensCreated() {
        assertEquals("Cat", Token.Cat.getDescription());
        assertEquals("(C)at", Token.Cat.getMenuString());
        assertEquals("C", Token.Cat.getTokenLetter());

        assertEquals("Dog", Token.Dog.getDescription());
        assertEquals("(D)og", Token.Dog.getMenuString());
        assertEquals("D", Token.Dog.getTokenLetter());

        assertEquals("Race car", Token.Car.getDescription());
        assertEquals("(R)ace car", Token.Car.getMenuString());
        assertEquals("R",Token.Car.getTokenLetter());

        assertEquals("(T)himble", Token.Thimble.getMenuString());
        assertEquals("(T)himble", Token.Thimble.getMenuString());
        assertEquals("T",Token.Thimble.getTokenLetter());

        assertEquals("Boot", Token.Boot.getDescription());
        assertEquals("(B)oot", Token.Boot.getMenuString());
        assertEquals("B",Token.Boot.getTokenLetter());

        assertEquals("Battleship", Token.Ship.getDescription());
        assertEquals("Battle(s)hip", Token.Ship.getMenuString());
        assertEquals("S",Token.Ship.getTokenLetter());

        assertEquals("Top hat", Token.Hat.getDescription());
        assertEquals("Top (h)at", Token.Hat.getMenuString());
        assertEquals("H",Token.Hat.getTokenLetter());

        assertEquals("Wheelbarrow", Token.Wheelbarrow.getDescription());
        assertEquals("(W)heelbarrow", Token.Wheelbarrow.getMenuString());
        assertEquals("W",Token.Wheelbarrow.getTokenLetter());
    }

}
