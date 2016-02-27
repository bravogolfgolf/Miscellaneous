package pkg.monopoly;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Card {


    private String instruction = "";

    public static Card create(String classType, String instruction) {
        if (classType.equals("CommunityChest")) return new CommunityChestCard(instruction);
        throw new IllegalArgumentException();
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public static List<Card> load(String filename) throws IOException {
        List<String> content = Files.readAllLines(Paths.get(filename));
        List<Card> cards = new ArrayList<Card>();
        for (String line : content) {
            String[] tokens = line.split(",");
            cards.add(Card.create(tokens[0], tokens[1]));
        }
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return instruction.equals(card.instruction);

    }

    @Override
    public int hashCode() {
        return instruction.hashCode();
    }
}

