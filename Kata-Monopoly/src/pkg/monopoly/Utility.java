package pkg.monopoly;

import java.util.List;

public class Utility extends Property {

    public Utility(String description, String group, int price) {
        super(description, group, price, 0);
    }

    @Override
    protected int calculateRentOwed(String sourceOfMove, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        List<Space> properties = getAllPropertiesInGroup();
        if (allPropertiesHaveSameOwner(properties))
            return numberRolled * 10 * sourceOfMoveMultiplier.value();
        if (sourceOfMove.equals("Card"))
            return numberRolled * 1 * sourceOfMoveMultiplier.value();
        return numberRolled * 4 * sourceOfMoveMultiplier.value();
    }
}