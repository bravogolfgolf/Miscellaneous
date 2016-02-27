package pkg.monopoly;

public class Card {


    private String instruction = "";

    public static Card create(String classType, String instruction){
        if (classType.equals("CommunityChest")) return new CommunityChest(instruction);
        throw new IllegalArgumentException();
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
