package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropertyUnMortgageTest {
    public static final int UNMORTGAGE_AMOUNT = -110;
    private Player player;
    private Player owner;
    private Property property;

    @Before
    public void setup() throws IOException {
        player = new Player("Cat");
        owner = new Player("Dog");
        property = new Railroad("Short Line", "Railroad", -1, -1);
        property.setPrice(200);
    }

    @After
    public void tearDown() {
        player = null;
        owner = null;
        property = null;
    }

    @Test
    public void testUnMortgageAmount() {
        assertEquals(UNMORTGAGE_AMOUNT, property.unMortgageAmount());
    }

    @Test
    public void testPlayerUnMortgagesProperty() {
        int expectedBalance = player.getCashBalance() + UNMORTGAGE_AMOUNT;
        int exceptedNetWorth = player.getNetWorth() + (property.getPrice() / 2);
        property.setOwner(player);
        property.setIsMortgaged(true);
        property.unMortgageBy(player);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(exceptedNetWorth, player.getNetWorth());
        assertEquals(false, property.isMortgaged());
        assertTrue(property.getOwner().equals(player));
    }

    @Test
    public void testPlayerTriesToUnMortgagePropertyAlreadyUnMortgaged() {
        int expectedBalance = player.getCashBalance();
        property.setOwner(player);
        property.setIsMortgaged(false);
        property.unMortgageBy(player);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(false, property.isMortgaged());
        assertTrue(property.getOwner().equals(player));
    }

    @Test
    public void testPlayerTriesToUnMortgageUnOwnedProperty() {
        int expectedBalance = player.getCashBalance();
        property.setIsMortgaged(true);
        property.unMortgageBy(player);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(true, property.isMortgaged());
        assertTrue(property.getOwner().isBank());
    }

    @Test
    public void testPlayerTriesToUnMortgagePropertyOwnedByAnother() {
        int expectedBalance = player.getCashBalance();
        property.setIsMortgaged(true);
        property.setOwner(owner);
        property.unMortgageBy(player);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(true, property.isMortgaged());
        assertTrue(property.getOwner().equals(owner));
    }
}
