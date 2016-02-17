package pkg.monopoly;

public class Space {

    private String description;
    private Space nextSpace;

    public Space(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setNextSpace(Space space) {
        nextSpace = space;
    }

    public void move(Player player, int numberRolled) {
        for (int i = 1; i < numberRolled; i++) {
            moveForwardOneSpace(player);
            player.getSpace().passBy(player);
        }
        moveForwardOneSpace(player);
        player.getSpace().landOn(player);
    }

    private void moveForwardOneSpace(Player player) {
        Space space = player.getSpace();
        Space next = space.getNextSpace();
        player.setSpace(next);
    }

    public Space getNextSpace() {
        return nextSpace;
    }

    public void passBy(Player player) {
    }

    public void landOn(Player player) {
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