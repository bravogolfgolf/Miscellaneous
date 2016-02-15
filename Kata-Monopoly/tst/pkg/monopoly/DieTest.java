package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DieTest {

    private Die die1;

    @Before
    public void setUp() throws Exception {
        die1 = new Die();
    }

    @Test
    public void testOneDieRolled() {
        int rollValue = die1.rollDie();
        assertTrue(rollValue >= 1 && rollValue <= 6);
    }

    @Test
    public void testTwoDieRolled() {
        int rollValue = die1.rollTwoDie();
        assertTrue(rollValue >= 2 && rollValue <= 12);
    }

}
