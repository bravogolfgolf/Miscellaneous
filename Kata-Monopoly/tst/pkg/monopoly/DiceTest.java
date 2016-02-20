package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void testTwoDieRolled() {
        Dice dice = new Dice();
        dice.rollTwoDie();
        int rollValue = dice.getTwoDieRollValue();
        assertTrue(rollValue >= 2 && rollValue <= 12);
    }

    @Test
    public void testDiceMockRollsDouble3sThenPlain4() {
        Dice diceMock = new DiceMockRollsDouble3sThenPlain4();
        assertTrue(diceMock.rollTwoDie());
        assertEquals(1, diceMock.getNumberOfDoublesInARow());
        assertEquals(6, diceMock.getTwoDieRollValue());
        assertFalse(diceMock.rollTwoDie());
        assertEquals(1, diceMock.getNumberOfDoublesInARow());
        assertEquals(4, diceMock.getTwoDieRollValue());
    }
}
