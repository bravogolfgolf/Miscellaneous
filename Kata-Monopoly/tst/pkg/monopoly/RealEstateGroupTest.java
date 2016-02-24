package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RealEstateGroupTest {

    private RealEstate mediterraneanAve;
    private RealEstate balticAve;
    private final Player player1 = new Player("Cat");
    private final Player player2 = new Player("Dog");

    @Before
    public void setUp() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        mediterraneanAve = (RealEstate) board.get(1);
        balticAve = (RealEstate) board.get(3);
    }

    @Test
    public void testPropertyGroup() throws IOException {
        assertEquals("Brown", mediterraneanAve.getGroup());
        assertEquals("Brown", balticAve.getGroup());
    }

    @Test
    public void testGetAllPropertiesOfSameGroup() throws IOException {
        assertEquals(2, mediterraneanAve.getAllPropertiesInGroup().size());
    }

    @Test
    public void testPropertiesOfSameGroupHaveSameOwners() throws IOException {
        mediterraneanAve.setOwner(player1);
        balticAve.setOwner(player1);
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertTrue(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOfSameGroupHaveDifferentOwners() throws IOException {
        mediterraneanAve.setOwner(player1);
        balticAve.setOwner(player2);
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertFalse(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testAtLeastOnePropertiesOfSameGroupIsOwnedByBank() throws IOException {
        mediterraneanAve.setOwner(player1);
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertFalse(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOfSameGroupAreAllOwnedByBank() throws IOException {
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertTrue(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOwnedBySameOwnerCostDoublesRent() {
//TODO
    }
}