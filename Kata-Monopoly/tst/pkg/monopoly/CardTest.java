package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest {

    private CommunityChestCard communityChestCard1;

    @Before
    public void setUp() throws Exception {
        communityChestCard1 = (CommunityChestCard) Card.create("CommunityChest", "Bank error in your favor – Collect $200");
    }

    @Test
    public void testCreateCommunityChestCard() {
        assertTrue("Bank error in your favor – Collect $200".equals(communityChestCard1.getInstruction()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard() {
        Card.create("Invalid", "Invalid");
    }

    @Test
    public void testReadOfCardDefinitionFile() throws IOException {
        final String filename = "Cards_TEST.txt";
        List<Card> expected = new ArrayList<Card>();
        List<Card> actual;
        expected.add(Card.create("CommunityChest", "Instruction1"));
        expected.add(Card.create("CommunityChest", "Instruction2"));
        actual = Card.load(filename);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.equals(actual));
        for (int index = 0; index < expected.size(); index++) {
            assertTrue(expected.get(index).equals(actual.get(index)));
        }
    }

    @Test
    public void testCardHashcode() {
        CommunityChestCard communityChestCard2 = (CommunityChestCard) Card.create("CommunityChest", "Bank error in your favor – Collect $200");
        assertEquals(communityChestCard1.hashCode(), communityChestCard2.hashCode());
    }
}
