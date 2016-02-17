package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    private Dice dice;

    @Before
    public void setUp() throws Exception {
        dice = new Dice();
        dice.rollTwoDie();
    }

    @After
    public void tearDown() throws Exception {
        dice = null;
    }

    @Test
    public void testTwoDieRolled() {
        int rollValue = dice.getTwoDieRollValue();
        assertTrue(rollValue >= 2 && rollValue <= 12);
    }

}
