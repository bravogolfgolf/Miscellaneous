package pkg.monopoly;

public class Dice {

    private int twoDieRollValue;
    private int numberOfDoublesInARow;

    public Boolean rollTwoDie() {
        int die1 = rollDie();
        int die2 = rollDie();
        twoDieRollValue = die1 + die2;
        if(die1 == die2) numberOfDoublesInARow++;
        return die1 == die2;
    }

    public int getTwoDieRollValue() {
        return twoDieRollValue;
    }

    public int getNumberOfDoublesInARow() {
        return numberOfDoublesInARow;
    }

    int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }
}