package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilityGroupTest {

    private static final int PRICE_OF_ELECTRIC = 150;
    private static final int PRICE_OF_WATER = 150;
    private Utility electric;
    private Utility water;
    private final Player player1 = new Player("Cat");
    private final Player player2 = new Player("Dog");

    @Before
    public void setUp() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        electric = (Utility) board.get(12);
        water = (Utility) board.get(28);
    }

    @Test
    public void testCreation() {
        Space property = Space.create("Utility", "Water Works", "Utility", -1);
        assertEquals("Water Works", property.getDescription());
        assertEquals("Utility",property.getGroup());
    }

    @Test
    public void testOwnership() {
        assertTrue(electric.getOwner().isBank());
        electric.setOwner(player1);
        assertEquals(player1, electric.getOwner());
        assertTrue(water.getOwner().isBank());
    }

    @Test
    public void testPrice() {
        assertEquals(PRICE_OF_ELECTRIC, electric.getPrice());
        assertEquals(PRICE_OF_WATER, water.getPrice());
    }

    @Test
    public void testPropertyGroup() throws IOException {
        assertEquals("Utility", electric.getGroup());
        assertEquals("Utility", water.getGroup());
    }

    @Test
    public void testGetAllPropertiesOfSameGroup() throws IOException {
        assertEquals(2, electric.getAllPropertiesInGroup().size());
    }

    @Test
    public void testPropertiesOfSameGroupHaveSameOwners() throws IOException {
        electric.setOwner(player1);
        water.setOwner(player1);
        List<Space> properties = electric.getAllPropertiesInGroup();
        assertTrue(electric.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOfSameGroupHaveDifferentOwners() throws IOException {
        electric.setOwner(player1);
        water.setOwner(player2);
        List<Space> properties = electric.getAllPropertiesInGroup();
        assertFalse(electric.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testAtLeastOnePropertiesOfSameGroupIsOwnedByBank() throws IOException {
        electric.setOwner(player1);
        List<Space> properties = electric.getAllPropertiesInGroup();
        assertFalse(electric.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOfSameGroupAreAllOwnedByBank() throws IOException {
        List<Space> properties = electric.getAllPropertiesInGroup();
        assertTrue(electric.allPropertiesHaveSameOwner(properties));
    }
}
