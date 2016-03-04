package pkg.monopoly;

public class MoveForwardNext extends Card {
    public MoveForwardNext(String cardType, String cardText, String space) {
        super();
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    void action(Player player) throws GoToJail.GoToJailException {}
}
