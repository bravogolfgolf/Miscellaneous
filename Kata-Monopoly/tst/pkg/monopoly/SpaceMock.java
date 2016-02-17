package pkg.monopoly;

public class SpaceMock extends Space {

    public int landOnCounter;
    public int passByCounter;

    public SpaceMock(String description) {
        super(description);
    }

    @Override
    public void landOn(Player player) {
        landOnCounter++;
    }

    @Override
    public void passBy(Player player) {
        passByCounter++;
    }
}
