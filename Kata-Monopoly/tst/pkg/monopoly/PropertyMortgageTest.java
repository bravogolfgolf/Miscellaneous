package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropertyMortgageTest {

    private static final int MORTGAGE_AMOUNT = 100;
    private Player player;
    private Property property;
    private Player owner;

    @Before
    public void setup() {
        player = new Player("Cat");
        owner = new Player("Dog");
        property = new Railroad("Short Line", "Railroad",200, 25);
    }

    @After
    public void tearDown() {
        player = null;
        owner = null;
        property = null;
    }

    @Test
    public void testMortgageAmount() {
        assertEquals(MORTGAGE_AMOUNT, property.mortgageAmount());
    }

    @Test
    public void testPlayerMortgagesProperty() {
        int expectedBalance = player.getCashBalance() + MORTGAGE_AMOUNT;
        int exceptedNetWorth = player.getNetWorth();
        property.setIsMortgaged(false);
        property.setOwner(player);
        property.mortgagedBy(player);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(exceptedNetWorth,player.getNetWorth());
        assertEquals(true, property.isMortgaged());
        assertTrue(property.getOwner().equals(player));
    }

    @Test
    public void testPlayerTriesToMortgagePropertyAlreadyMortgaged() {
        int expectedBalance = player.getCashBalance();
        property.setIsMortgaged(true);
        property.setOwner(player);
        property.mortgagedBy(player);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(true, property.isMortgaged());
        assertTrue(property.getOwner().equals(player));
    }

    @Test
    public void testPlayerTriesToMortgageUnOwnedProperty() {
        int expectedBalance = player.getCashBalance();
        property.setIsMortgaged(false);
        property.mortgagedBy(player);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(false, property.isMortgaged());
        assertTrue(property.getOwner().isBank());
    }

    @Test
    public void testPlayerTriesToMortgagePropertyOwnedByAnother() {
        int expectedBalance = player.getCashBalance();
        property.setIsMortgaged(false);
        property.setOwner(owner);
        property.mortgagedBy(player);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(false, property.isMortgaged());
        assertTrue(property.getOwner().equals(owner));
    }
}
