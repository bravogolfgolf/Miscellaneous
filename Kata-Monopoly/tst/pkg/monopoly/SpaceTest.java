package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceTest {

    private Player player;
    private Space space;
    private DiceMock diceMock;
    private SpaceMockLandOnPassByCounter start;
    private SpaceMockLandOnPassByCounter space1;
    private SpaceMockLandOnPassByCounter space2;

    @Before
    public void setup() {
        player = new Player("Cat");
        space = Space.create("Other", "SpaceDescription");
        diceMock = new DiceMock();
        start = new SpaceMockLandOnPassByCounter("Start");
        space1 = new SpaceMockLandOnPassByCounter("Space1");
        space2 = new SpaceMockLandOnPassByCounter("Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
    }

    @After
    public void tearDown() {
        player = null;
        space = null;
        diceMock = null;
        start = null;
        space1 = null;
        space2 = null;
    }

    @Test
    public void testCreateSpace() {
        assertEquals("SpaceDescription", space.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceNonPropertyThrowsException() throws IllegalArgumentException {
        Space.create("Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceUtilitiyThrowsException() throws IllegalArgumentException {
        Space.create("Invalid", "Invalid", "Invalid", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceRealEstateOrRailroadThrowsException() throws IllegalArgumentException {
        Space.create("Invalid", "Invalid", "Invalid", -1, -1);
    }

    @Test
    public void testSetNextSpace() {
        assertTrue(start.getNextSpace().equals(space1));
    }

    @Test
    public void testLandOnSpaceWithNoChangeInCash() {
        int expectedEndingBalance = player.getCashBalance();
        space.landOn(player, 0);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBySpaceWithNoChangeInCash() {
        int expectedEndingBalance = player.getCashBalance();
        space.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testLandOnMethodCalledProperly() {
        player.setSpace(start);
        player.takeATurn(diceMock);
        assertEquals(0, start.landOnCounter);
        assertEquals(0, space1.landOnCounter);
        assertEquals(1, space2.landOnCounter);
    }

    @Test
    public void testPassByMethodCalledProperly() {
        player.setSpace(start);
        player.takeATurn(diceMock);
        assertEquals(0, start.passByCounter);
        assertEquals(1, space1.passByCounter);
        assertEquals(0, space2.passByCounter);
    }

    @Test
    public void testReadOfSpaceDefinitionFile() throws IOException {
        final String filename = "Spaces_TEST.txt";
        List<Space> expected = new ArrayList<Space>();
        List<Space> actual;
        expected.add(Space.create("Other", "Description"));
        expected.add(Space.create("RealEstate", "Description", "Group", 78, 3));
        actual = Space.load(filename);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.equals(actual));
        for (int index = 0; index < expected.size(); index++) {
            assertTrue(expected.get(index).equals(actual.get(index)));
        }
    }

    @Test
    public void testEqualsAndHashcode() {
        Space space1 = Space.create("RealEstate", "Description", "Group", -1, -1);
        space1.setNextSpace(Space.create("Other", "Description"));
        Space space2 = Space.create("RealEstate", "Description", "Group", -1, -1);
        space2.setNextSpace(Space.create("Other", "Description"));
        assertTrue(space1.equals(space2));
        assertTrue(space1.hashCode() == space2.hashCode());
    }
}
