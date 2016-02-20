package pkg.monopoly;

public class SpaceMockMoveCounter extends Space {

    int moveCounter;

    @Override
    public void move(Player player, int numberRolled) {
        moveCounter++;
    }
}
