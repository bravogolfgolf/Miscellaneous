package pkg.monopoly;

public class MoveBack extends Card {
    public MoveBack(String cardType, String cardText, String space) {
        super();
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    void action(Player player) throws GoToJail.GoToJailException {}
}
