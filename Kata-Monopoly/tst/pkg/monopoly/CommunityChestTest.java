package pkg.monopoly;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommunityChestTest {

    @Test
    public void testCreation() {
        Space communityChest = Space.create("CommunityChest", "Community Chest");
        assertEquals("Community Chest", communityChest.getDescription());
    }

    @Ignore
    public void testLandOnDrawsMoveCard() throws GoToJail.GoToJailException {
        Space communityChest = Space.create("CommunityChest", "Community Chest");
        Player player = new Player("Cat");
        communityChest.landOn(player);
    }
}
