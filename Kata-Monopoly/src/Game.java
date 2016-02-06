import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    List<Integer> properties = new ArrayList<Integer>(Arrays.asList(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 31, 33, 34, 35, 36, 37, 38, 39));

    public int getSize() {
        return properties.size();
    }
}
