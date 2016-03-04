package pkg.monopoly;

public class SpaceMockLandOnPassByCounter extends Space {

    public int landOnCounter;
    public int passByCounter;

    public SpaceMockLandOnPassByCounter(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, String sourceOfMove) {
        landOnCounter++;
    }

    @Override
    public void passBy(Player player) {
        passByCounter++;
    }
}
