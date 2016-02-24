package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropertyTest {

    public static final int PRICE_OF_PROPERTY = 200;
    public static final int RENT = 25;
    private Player player;
    private RealEstate realEstate;
    private Player owner;
    private int playerBeginningBalance;
    private int ownerBeginningBalance;

    @Before
    public void setUp() throws Exception {
        player = new Player("Cat");
        owner = new Player("Dog");
        realEstate = new RealEstate("RealEstate", "Group", -1);
        realEstate.setPrice(PRICE_OF_PROPERTY);
        realEstate.setRent(RENT);
        playerBeginningBalance = player.getCashBalance();
        ownerBeginningBalance = owner.getCashBalance();
    }

    @After
    public void teardown() {
        player = null;
        owner = null;
        realEstate = null;
    }

    @Test
    public void testPrice() {
        assertEquals(PRICE_OF_PROPERTY, realEstate.getPrice());
    }

    @Test
    public void testRent() {
        assertEquals(RENT, realEstate.getRent());
    }

    @Test
    public void testMortgaged() {
        assertEquals(false, realEstate.isMortgaged());
        realEstate.setIsMortgaged(true);
        assertEquals(true, realEstate.isMortgaged());
    }

    @Test
    public void testLandOnUnownedProperty() {
        assertTrue(realEstate.getOwner().isBank());
        int endingBalance = playerBeginningBalance - PRICE_OF_PROPERTY;
        realEstate.landOn(player);
        assertEquals(player, realEstate.getOwner());
        assertEquals(endingBalance, player.getCashBalance());
    }

    @Test
    public void testLandOnOwnedAndUnmortgagedProperty() {
        ownedUnMortgagedProperty(owner);
        int playerEndingBalance = playerBeginningBalance - RENT;
        int ownerEndingBalance = ownerBeginningBalance + RENT;
        realEstate.landOn(player);
        assertEquals(owner, realEstate.getOwner());
        assertEquals(playerEndingBalance, player.getCashBalance());
        assertEquals(ownerEndingBalance, owner.getCashBalance());
    }

    private void ownedUnMortgagedProperty(Player player) {
        realEstate.setOwner(player);
        assertEquals(player, realEstate.getOwner());
        assertEquals(false, realEstate.isMortgaged());
    }

    @Test
    public void testLandOnOwnedAndMortgagedProperty() {
        ownedMortgagedProperty();
        realEstate.landOn(player);
        assertEquals(owner, realEstate.getOwner());
        assertEquals(playerBeginningBalance, player.getCashBalance());
        assertEquals(ownerBeginningBalance, owner.getCashBalance());
    }

    private void ownedMortgagedProperty() {
        realEstate.setOwner(owner);
        realEstate.setIsMortgaged(true);
        assertEquals(owner, realEstate.getOwner());
        assertEquals(true, realEstate.isMortgaged());
    }

    @Test
    public void testPlayerDoesNotPayHimselfRent() {
        PlayerMockCashBalanceCounter playerMock = new PlayerMockCashBalanceCounter();
        ownedUnMortgagedProperty(playerMock);
        realEstate.landOn(playerMock);
        assertEquals(0,playerMock.changeCashBalanceBy);
    }


}
