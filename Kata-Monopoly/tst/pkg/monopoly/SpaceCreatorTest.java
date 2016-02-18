package pkg.monopoly;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SpaceCreatorTest {

    private Space space;
    private Space newSpace = new Space("");
    private List<Space> spaces = new ArrayList<Space>();

    @Test
    public void testWriteAndReadOfSpaceDefinitionFile() throws IOException {
        final String filename = "Spaces_US.txt";
        space = new Space("SpaceWriteReadTest");
        space.store(filename);
        newSpace.load(filename);
        assertTrue(newSpace.equals(space));
    }
}
