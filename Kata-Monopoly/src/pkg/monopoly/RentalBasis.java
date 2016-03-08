package pkg.monopoly;

public class RentalBasis {

    private final int[] renatalBases = new int[6];

    public RentalBasis(int rent, int improvementOne, int improvementTwo, int improvementThree, int improvementFour, int improvmentFive) {
        renatalBases[0] = rent;
        renatalBases[1] = improvementOne;
        renatalBases[2] = improvementTwo;
        renatalBases[3] = improvementThree;
        renatalBases[4] = improvementFour;
        renatalBases[5] = improvmentFive;
    }

    public int get(int numberOfImprovement) {
        return renatalBases[numberOfImprovement];
    }
}
