package pkg.monopoly;

import java.util.ArrayList;
import java.util.List;

public class PlayerMockAlternateOrder extends Player {

        public static final List<Player> order = new ArrayList<Player>();

    public PlayerMockAlternateOrder() {
        super();
    }

    @Override
    public void takeATurn(Dice dice) {
            order.add(this);
    }
}