package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    @Test
    public void testTokensCreated() {
        assertEquals("Cat", Token.Cat.getDescription());
        assertEquals("(C)at", Token.Cat.getMenuString());

        assertEquals("Dog", Token.Dog.getDescription());
        assertEquals("(D)og", Token.Dog.getMenuString());

        assertEquals("Race car", Token.Car.getDescription());
        assertEquals("(R)ace car", Token.Car.getMenuString());

        assertEquals("(T)himble", Token.Thimble.getMenuString());
        assertEquals("(T)himble", Token.Thimble.getMenuString());

        assertEquals("Boot", Token.Boot.getDescription());
        assertEquals("(B)oot", Token.Boot.getMenuString());

        assertEquals("Battleship", Token.Ship.getDescription());
        assertEquals("(B)attleship", Token.Ship.getMenuString());

        assertEquals("Top hat", Token.Hat.getDescription());
        assertEquals("Top (h)at", Token.Hat.getMenuString());

        assertEquals("Wheelbarrow", Token.Wheelbarrow.getDescription());
        assertEquals("(W)heelbarrow", Token.Wheelbarrow.getMenuString());
    }

}
