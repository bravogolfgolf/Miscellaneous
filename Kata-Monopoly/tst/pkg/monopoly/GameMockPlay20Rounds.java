package pkg.monopoly;

import java.io.IOException;

public class GameMockPlay20Rounds extends Game {
    public GameMockPlay20Rounds(String spaceDefinitionFile) throws IOException {
        super(spaceDefinitionFile);
    }

    @Override
    public void play() {
        for (int i = 0; i < 20; i++)
            for (Player player : players) {
                player.takeATurn(dice);
                player.manageProperties();
            }
    }
}
