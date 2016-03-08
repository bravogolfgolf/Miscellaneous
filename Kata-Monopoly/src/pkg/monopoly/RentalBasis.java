package pkg.monopoly;

public class RentalBasis {

    private final int[] rentalBases = new int[6];

    public RentalBasis(int rent, int improvementOne, int improvementTwo, int improvementThree, int improvementFour, int improvementFive) {
        rentalBases[0] = rent;
        rentalBases[1] = improvementOne;
        rentalBases[2] = improvementTwo;
        rentalBases[3] = improvementThree;
        rentalBases[4] = improvementFour;
        rentalBases[5] = improvementFive;
    }

    public int get(int numberOfImprovement) {
        return rentalBases[numberOfImprovement];
    }
}
