package pkg.monopoly;

import java.util.List;

public class Space {

    private String description;

    public Space(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void landOn(Player player) {
    }

    public void passBy(Player player) {
    }

    public void move(Player player, int numberRolled) {
        Board board = new Board();
        List<Space> navigationList;
        navigationList = board.getNavigationList(player);
        for (int i = 0; i <= numberRolled; i++) {
            player.setSpace(navigationList.get(i));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Space space = (Space) o;

        return description.equals(space.description);

    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }
}