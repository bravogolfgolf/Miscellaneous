package pkg.monopoly;

public class DiceMockRollsDouble3sThenPlain4 extends Dice {

    private int numberOfRollDie = -1;

    @Override
    int rollDie() throws IllegalArgumentException {
        numberOfRollDie++;
        if (numberOfRollDie == 0) return 3;
        if (numberOfRollDie == 1) return 3;
        if (numberOfRollDie == 2) return 3;
        if (numberOfRollDie == 3) return 1;
        return numberOfRollDie;
    }
}
