package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommunityChestTest {

    @Test
    public void testCardCreation() {
        Card card = new Card("Advance to Go");
        assertTrue("Advance to Go".endsWith(card.getInstructions()));
    }
}
