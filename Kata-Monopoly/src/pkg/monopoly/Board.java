package pkg.monopoly;

import java.util.*;

public class Board {

    public static final int SIZE_ON_BOARD = 40;

    private List<Space> spaces = new ArrayList<Space>();

    public Board() {
        spaces.add(new Go("Go"));
        spaces.add(new Space("Space1"));
        spaces.add(new Space("Space2"));
        spaces.add(new Space("Space3"));
        spaces.add(new Space("Space4"));
        spaces.add(new Space("Space5"));
        spaces.add(new Space("Space6"));
        spaces.add(new Space("Space7"));
        spaces.add(new Space("Space8"));
        spaces.add(new Space("Space9"));
        spaces.add(new Space("Space10"));
        spaces.add(new Space("Space11"));
        spaces.add(new Space("Space12"));
        spaces.add(new Space("Space13"));
        spaces.add(new Space("Space14"));
        spaces.add(new Space("Space15"));
        spaces.add(new Space("Space16"));
        spaces.add(new Space("Space17"));
        spaces.add(new Space("Space18"));
        spaces.add(new Space("Space19"));
        spaces.add(new Space("Space20"));
        spaces.add(new Space("Space21"));
        spaces.add(new Space("Space22"));
        spaces.add(new Space("Space23"));
        spaces.add(new Space("Space24"));
        spaces.add(new Space("Space25"));
        spaces.add(new Space("Space26"));
        spaces.add(new Space("Space27"));
        spaces.add(new Space("Space28"));
        spaces.add(new Space("Space29"));
        spaces.add(new Space("Space30"));
        spaces.add(new Space("Space31"));
        spaces.add(new Space("Space32"));
        spaces.add(new Space("Space33"));
        spaces.add(new Space("Space34"));
        spaces.add(new Space("Space35"));
        spaces.add(new Space("Space36"));
        spaces.add(new Space("Space37"));
        spaces.add(new Space("Space38"));
        spaces.add(new Space("Space39"));
    }

    public int getBoardSize() {
        return spaces.size();
    }

    public Space getSpace(int index) {
        return spaces.get(index);
    }

    public List<Space> getNavigationList(Player player) {
        Space location = player.getLocation();
        int locationIndex = spaces.indexOf(location);

        List<Space> navigationList = new ArrayList<Space>();

        for (int i = locationIndex; i < spaces.size(); i++)
            navigationList.add(spaces.get(i));

        if (locationIndex > 0)
            for (int i = 0; i < locationIndex; i++)
                navigationList.add(spaces.get(i));

        return navigationList;
    }
}
