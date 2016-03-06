package pkg.monopoly;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

abstract class Space {

    private String description = "";
    private String group = "";
    private Space nextSpace;
    protected int numberRolled;

    public static Space create(String classType, String description, String group, int price, int rent, int house1Rent, int house2Rent, int house3Rent, int house4Rent, int hotelRent) {
        if (classType.equals("RealEstate"))
            return new RealEstate(description, group, price, rent, house1Rent, house2Rent, house3Rent, house4Rent, hotelRent);
        throw new IllegalArgumentException("Incorrect value");
    }

    public static Space create(String classType, String description, String group, int price, int rent) {
        if (classType.equals("Railroad")) return new Railroad(description, group, price, rent);
        throw new IllegalArgumentException("Incorrect value");
    }

    public static Space create(String classType, String description, String group, int price) {
        if (classType.equals("Utility")) return new Utility(description, group, price);
        throw new IllegalArgumentException("Incorrect value");
    }

    public static Space create(String classType, String description) {
        if (classType.equals("Go")) return new Go(description);
        if (classType.equals("FreeParking")) return new FreeParking(description);
        if (classType.equals("Jail")) return new Jail(description);
        if (classType.equals("GoToJail")) return new GoToJail(description);
        if (classType.equals("IncomeTax")) return new IncomeTax(description);
        if (classType.equals("LuxuryTax")) return new LuxuryTax(description);
        if (classType.equals("CommunityChest")) return new CommunityChest(description);
        if (classType.equals("Chance")) return new Chance(description);
        throw new IllegalArgumentException("Incorrect value");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setNextSpace(Space space) {
        nextSpace = space;
    }

    public Space getNextSpace() {
        return nextSpace;
    }

    public void move(Player player, int numberRolled, String sourceOfMove) {
        this.numberRolled = numberRolled;
        for (int i = 1; i < numberRolled; i++) {
            moveForwardOneSpace(player);
            player.getSpace().passBy(player);
        }
        moveForwardOneSpace(player);
        player.getSpace().landOn(player, sourceOfMove);
    }

    private void moveForwardOneSpace(Player player) {
        Space space = player.getSpace();
        Space next = space.getNextSpace();
        player.setSpace(next);
    }

    public void passBy(Player player) {
    }

    public void landOn(Player player, String sourceOfMove)  {
    }

    public Space searchForSpaceByDescription(String description) {
        Space currentSpace = this;
        Space nextSpace = currentSpace.getNextSpace();

        while (!nextSpace.getDescription().equals(description)) {
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        return nextSpace;
    }

    public Space searchForNextSpaceInGroup(String group) {
        Space currentSpace = this;
        Space nextSpace = currentSpace.getNextSpace();

        while (!nextSpace.getGroup().equals(group)) {
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        return nextSpace;
    }


    public int getNumberOfSpacesTo(String description) {
        int result = 0;
        Space currentSpace = this;
        Space nextSpace = currentSpace.getNextSpace();
        Space destinationSpace = searchForSpaceByDescription(description);
        while (!currentSpace.equals(destinationSpace)) {
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
            result++;
        }
        return result;
    }

    public static List<RealEstate> getAllRealEstateOf(Player player) {
        List<RealEstate> realEstateHoldings = new ArrayList<RealEstate>();
        Space startingSpace = player.getSpace();
        Space currentSpace = startingSpace;
        Space nextSpace = currentSpace.getNextSpace();
        while (!nextSpace.equals(startingSpace)) {
            if (nextSpace.getClass().getSimpleName().equals("RealEstate")) {
                RealEstate realEstate = (RealEstate) nextSpace;
                if (realEstate.getOwner().equals(player)) {
                    realEstateHoldings.add(realEstate);
                }
            }
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        return realEstateHoldings;
    }

    public static List<Space> load(String filename) throws IOException {
        List<String> content = Files.readAllLines(Paths.get(filename));
        List<Space> spaces = new ArrayList<Space>();
        for (String line : content) {
            String[] tokens = line.split(";");
            if (tokens[0].equals("RealEstate"))
                spaces.add(Space.create(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9])));
            else if (tokens[0].equals("Railroad"))
                spaces.add(Space.create(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
            else if (tokens[0].equals("Utility"))
                spaces.add(Space.create(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3])));
            else spaces.add(Space.create(tokens[0], tokens[1]));
        }
        return spaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Space space = (Space) o;

        return description.equals(space.description) && (nextSpace != null ? nextSpace.equals(space.nextSpace) : space.nextSpace == null && group.equals(space.group));

    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + (nextSpace != null ? nextSpace.hashCode() : 0);
        result = 31 * result + group.hashCode();
        return result;
    }
}