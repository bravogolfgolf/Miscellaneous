package pkg.monopoly;

public class DiceMockRollsDoubleTwiceThenNot extends Dice {

    private int numberOfrollDie = -1;

    @Override
    int rollDie() throws IllegalArgumentException {
        numberOfrollDie++;
        if (numberOfrollDie == 0) return 4;
        if (numberOfrollDie == 1) return 4;
        if (numberOfrollDie == 2) return 5;
        if (numberOfrollDie == 3) return 5;
        if (numberOfrollDie == 4) return 5;
        if (numberOfrollDie == 5) return 3;
        return numberOfrollDie;
    }
}

