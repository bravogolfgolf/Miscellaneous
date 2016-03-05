package pkg.monopoly;

public class DiceMockRollsDoubleThreeTimesInARow extends Dice {
    private int numberOfRollDie = -1;

    @Override
    int rollDie() throws IllegalArgumentException {
        numberOfRollDie++;
        if (numberOfRollDie == 0) return 2;
        if (numberOfRollDie == 1) return 2;
        if (numberOfRollDie == 2) return 5;
        if (numberOfRollDie == 3) return 5;
        if (numberOfRollDie == 4) return 3;
        if (numberOfRollDie == 5) return 3;
        return numberOfRollDie;
    }
}

