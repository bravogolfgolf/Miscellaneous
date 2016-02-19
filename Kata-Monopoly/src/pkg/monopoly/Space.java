package pkg.monopoly;

import java.io.*;

abstract class Space {

    private String description;
    private Space nextSpace;

    public static Space create(String classType, String description) {
        if (classType.equals("Go")) return new Go(description);
        if (classType.equals("Property")) return new Property(description);
        if (classType.equals("Other")) return new Other(description);
        if (classType.equals("GoToJail")) return new GoToJail(description);
        if (classType.equals("IncomeTax")) return new IncomeTax(description);
        if (classType.equals("LuxuryTax")) return new LuxuryTax(description);
        throw new IllegalArgumentException("Incorrect value");
    }

    public void setDescription(String description) {
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

    public static Space load(String filename) throws IOException {
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            String[] tokens = line.split(",");
            return Space.create(tokens[0], tokens[1]);
        } finally {
            if (reader != null) {
                reader.close();
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