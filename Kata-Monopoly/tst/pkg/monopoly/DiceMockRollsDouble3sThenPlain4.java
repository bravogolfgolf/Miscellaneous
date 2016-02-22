package pkg.monopoly;

public class DiceMockRollsDouble3sThenPlain4 extends Dice {

    private int numberOfrollDie = -1;

    @Override
    int rollDie() throws IllegalArgumentException {
        numberOfrollDie++;
        if (numberOfrollDie == 0) return 3;
        if (numberOfrollDie == 1) return 3;
        if (numberOfrollDie == 2) return 3;
        if (numberOfrollDie == 3) return 1;
        return numberOfrollDie;
    }
}
