package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuItemsTest {

    @Test
    public void testTokensCreated() {
        assertEquals("Cat", MenuItems.Cat.getDescription());
        assertEquals("(C)at", MenuItems.Cat.getMenuString());
        assertEquals("C", MenuItems.Cat.getTokenLetter());

        assertEquals("Dog", MenuItems.Dog.getDescription());
        assertEquals("(D)og", MenuItems.Dog.getMenuString());
        assertEquals("D", MenuItems.Dog.getTokenLetter());

        assertEquals("Race car", MenuItems.Car.getDescription());
        assertEquals("(R)ace car", MenuItems.Car.getMenuString());
        assertEquals("R", MenuItems.Car.getTokenLetter());

        assertEquals("(T)himble", MenuItems.Thimble.getMenuString());
        assertEquals("(T)himble", MenuItems.Thimble.getMenuString());
        assertEquals("T", MenuItems.Thimble.getTokenLetter());

        assertEquals("Boot", MenuItems.Boot.getDescription());
        assertEquals("(B)oot", MenuItems.Boot.getMenuString());
        assertEquals("B", MenuItems.Boot.getTokenLetter());

        assertEquals("Battleship", MenuItems.Ship.getDescription());
        assertEquals("Battle(s)hip", MenuItems.Ship.getMenuString());
        assertEquals("S", MenuItems.Ship.getTokenLetter());

        assertEquals("Top hat", MenuItems.Hat.getDescription());
        assertEquals("Top (h)at", MenuItems.Hat.getMenuString());
        assertEquals("H", MenuItems.Hat.getTokenLetter());

        assertEquals("Wheelbarrow", MenuItems.Wheelbarrow.getDescription());
        assertEquals("(W)heelbarrow", MenuItems.Wheelbarrow.getMenuString());
        assertEquals("W", MenuItems.Wheelbarrow.getTokenLetter());
    }

}
