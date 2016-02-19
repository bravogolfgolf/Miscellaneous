package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceTest {

    private Player player;
    private DiceMock diceMock;
    private SpaceMock start;
    private SpaceMock space1;
    private SpaceMock space2;

    @Before
    public void setup() {
        player = new Player();
        diceMock = new DiceMock();
        start = new SpaceMock("Start");
        space1 = new SpaceMock("Space1");
        space2 = new SpaceMock("Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
    }

    @After
    public void tearDown() {
        player = null;
        diceMock = null;
        start = null;
        space1 = null;
        space2 = null;
    }

    @Test
    public void testCreateSpace() {
        Space space = new Space("Space");
        assertEquals("Space", space.getDescription());
    }

    @Test
    public void testSetNextSpace() {
        Space start = new Space("Start");
        Space space1 = new Space("Space1");
        start.setNextSpace(space1);
        assertTrue(start.getNextSpace().equals(space1));
    }

    @Test
    public void testLandOnSpaceWithNoChangeInCash() {
        Player player = new Player();
        Space space = new Space("Space");
        int expectedEndingBalance = player.getCashBalance();
        space.landOn(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBySpaceWithNoChangeInCash() {
        Player player = new Player();
        Space space = new Space("Space");
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
    public void testWriteAndReadOfSpaceDefinitionFile() throws IOException {
        final String filename = "Spaces_Test.txt";
        Space space = Space.create("Space","SpaceWriteReadTest");
        Space newSpace = Space.load(filename);
        assertTrue(newSpace.equals(space));
    }

    @Test
    public void testEqualsAndHashcode() {
        Space space1 = new Space("Space");
        space1.setNextSpace(new Space("Next"));
        Space space2 = new Space("Space");
        space2.setNextSpace(new Space("Next"));
        assertTrue(space1.equals(space2));
        assertTrue(space1.hashCode() == space2.hashCode());
    }
}
