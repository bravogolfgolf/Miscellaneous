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

    public void landOn(Player player) {
    }

    public void passBy(Player player) {
    }

    public void move(Player player, int numberRolled) {
        for (int i = 0; i < numberRolled; i++) {
            Space space = player.getSpace();
            Space next = space.getNextSpace();
            player.setSpace(next);
        }
    }

    public Space getNextSpace() {
        return nextSpace;
    }

    public void setNextSpace(Space space) {
        nextSpace = space;
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