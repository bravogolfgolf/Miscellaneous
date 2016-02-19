package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropertyTest {

    public static final int PRICE_OF_PROPERTY = 200;
    public static final int RENT = 25;
    public static final int MORTGAGE_AMOUNT = 100;
    public static final int UNMORTGAGE_AMOUNT = -110;
    private Player player;
    private Property property;
    private Player owner;
    private int playerBeginningBalance;
    private int ownerBeginningBalance;

    @Before
    public void setUp() throws Exception {
        player = new Player();
        owner = new Player();
        property = new Property("Reading Property");
        property.setPrice(PRICE_OF_PROPERTY);
        property.setRent(RENT);
        playerBeginningBalance = player.getCashBalance();
        ownerBeginningBalance = owner.getCashBalance();
    }

    @After
    public void teardown() {
        player = null;
        owner = null;
        property = null;
    }

    @Test
    public void testPropertyCreation() {
        Space property = Space.create("Property", "Short Line");
        assertEquals("Short Line", property.getDescription());
    }

    @Test
    public void testOwnership() {
        property.setOwner(player);
        assertEquals(player, property.getOwner());
    }

    @Test
    public void testPrice() {
        assertEquals(PRICE_OF_PROPERTY, property.getPrice());
    }

    @Test
    public void testRent() {
        assertEquals(RENT, property.getRent());
    }

    @Test
    public void testMortgaged() {
        assertEquals(false, property.isMortgaged());
        property.setIsMortgaged(true);
        assertEquals(true, property.isMortgaged());
    }

    @Test
    public void testLandOnUnownedProperty() {
        assertEquals(null, property.getOwner());
        int endingBalance = playerBeginningBalance - PRICE_OF_PROPERTY;
        property.landOn(player);
        assertEquals(player, property.getOwner());
        assertEquals(endingBalance, player.getCashBalance());
    }

    @Test
    public void testLandOnOwnedAndUnmortgagedProperty() {
        ownedUnMortgagedProperty();
        int playerEndingBalance = playerBeginningBalance - RENT;
        int ownerEndingBalance = ownerBeginningBalance + RENT;
        property.landOn(player);
        assertEquals(owner, property.getOwner());
        assertEquals(playerEndingBalance, player.getCashBalance());
        assertEquals(ownerEndingBalance, owner.getCashBalance());
    }

    private void ownedUnMortgagedProperty() {
        property.setOwner(owner);
        assertEquals(owner, property.getOwner());
        assertEquals(false, property.isMortgaged());
    }

    @Test
    public void testLandOnOwnedAndMortgagedProperty() {
        ownedMortgagedProperty();
        property.landOn(player);
        assertEquals(owner, property.getOwner());
        assertEquals(playerBeginningBalance, player.getCashBalance());
        assertEquals(ownerBeginningBalance, owner.getCashBalance());
    }

    private void ownedMortgagedProperty() {
        property.setOwner(owner);
        property.setIsMortgaged(true);
        assertEquals(owner, property.getOwner());
        assertEquals(true, property.isMortgaged());
    }

    @Test
    public void testMortgageAmount() {
        assertEquals(MORTGAGE_AMOUNT,property.mortgageAmount());
    }

    @Test
    public void testUnMortgageAmount() {
        assertEquals(UNMORTGAGE_AMOUNT, property.unMortgageAmount());
    }
}
