package pkg.monopoly;

import java.util.ArrayList;
import java.util.List;

public class PlayerMockAlternateOrder extends Player {

        public static final List<Player> order = new ArrayList<Player>();

    public PlayerMockAlternateOrder(Token token) {
        super(token);
    }

    @Override
    public int takeATurn() {
            order.add(this);
        return -1;
    }
}