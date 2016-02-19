package pkg.monopoly;

import java.io.*;

public class Space {

    private String description;
    private Space nextSpace;

    public Space(String description) {
        this.description = description;
    }

    public static Space create(String description) {
        return new Space(description);
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

    public static Space load(String filename) throws IOException {
        DataInputStream input = null;
        String line;
        try {
            input = new DataInputStream(new FileInputStream(filename));
            line = input.readUTF();
            String[] tokens = line.split(",");
            return Space.create(tokens[1]);

        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Space space = (Space) o;

        return description.equals(space.description) && (nextSpace != null ?
                nextSpace.equals(space.nextSpace) : space.nextSpace == null);
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + (nextSpace != null ? nextSpace.hashCode() : 0);
        return result;
    }
}