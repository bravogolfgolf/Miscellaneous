package pkg.monopoly;

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