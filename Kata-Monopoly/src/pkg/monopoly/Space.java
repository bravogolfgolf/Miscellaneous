package pkg.monopoly;

public class Space {
    private final String description;
    private final int id;

    public Space(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getID() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void landOn(Player player) {}

    public void passBy(Player player) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Space space = (Space) o;

        return id == space.id && (description != null ? description.equals(space.description) : space.description == null);

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
