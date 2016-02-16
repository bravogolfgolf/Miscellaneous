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
}
