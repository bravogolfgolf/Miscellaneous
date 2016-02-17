package pkg.monopoly;

import java.util.*;

public class Board {

    public static final int SIZE_ON_BOARD = 40;
    public static final int LAST_LOCATION_ON_BOARD = 39;

    private List<Space> spaces = new ArrayList<Space>();

    public Board() {
        spaces.add(new Space(0, "Go"));
        spaces.add(new Space(1, "Mediterranean Avenue"));
        spaces.add(new Space(2, "Community Chest"));
        spaces.add(new Space(3, "Baltic Avenue"));
        spaces.add(new Space(4, "Income Tax"));
        spaces.add(new Space(5, "Reading Railroad"));
        spaces.add(new Space(6, "Oriental Avenue"));
        spaces.add(new Space(7, "Chance"));
        spaces.add(new Space(8, "Vermont Avenue"));
        spaces.add(new Space(9, "Connecticut Avenue"));
        spaces.add(new Space(10, "Jail"));
        spaces.add(new Space(11, "St. Charles Place"));
        spaces.add(new Space(12, "Electric Company"));
        spaces.add(new Space(13, "States Avenue"));
        spaces.add(new Space(14, "Virginia Avenue"));
        spaces.add(new Space(15, "Pennsylvania Railroad"));
        spaces.add(new Space(16, "St. James Place"));
        spaces.add(new Space(17, "Community Chest"));
        spaces.add(new Space(18, "Tennessee Avenue"));
        spaces.add(new Space(19, "New York Avenue"));
        spaces.add(new Space(20, "Free Parking"));
        spaces.add(new Space(21, "Kentucky Avenue"));
        spaces.add(new Space(22, "Chance"));
        spaces.add(new Space(23, "Indiana Avenue"));
        spaces.add(new Space(24, "Illinois Avenue"));
        spaces.add(new Space(25, "B & O Railroad"));
        spaces.add(new Space(26, "Atlantic Avenue"));
        spaces.add(new Space(27, "Ventnor Avenue"));
        spaces.add(new Space(28, "Water Works"));
        spaces.add(new Space(29, "Marvin Gardens"));
        spaces.add(new Space(30, "Go to Jail"));
        spaces.add(new Space(31, "Pacific Avenue"));
        spaces.add(new Space(32, "North Carolina Avenue"));
        spaces.add(new Space(33, "Community Chest"));
        spaces.add(new Space(34, "Pennsylvania Avenue"));
        spaces.add(new Space(35, "Short Line"));
        spaces.add(new Space(36, "Chance"));
        spaces.add(new Space(37, "Park Place"));
        spaces.add(new Space(38, "Luxury Tax"));
        spaces.add(new Space(39, "Boardwalk"));
    }

    public int getBoardSize() {
        return spaces.size();
    }

    public Space getSpace(int index) {
        return spaces.get(index);
    }

    public List<Space> getNavigationList(Token token) {
        int location = token.getLocation();
        List<Space> navigationList = new ArrayList<Space>();

        for (int i = location; i < spaces.size(); i++)
            navigationList.add(spaces.get(i));

        if (location > 0)
            for (int i = 0; i < location; i++)
                navigationList.add(spaces.get(i));

        return navigationList;
    }
}
