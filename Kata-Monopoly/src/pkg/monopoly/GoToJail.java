package pkg.monopoly;

public class GoToJail extends Space {

    private Space destination = null;

    public GoToJail(String description) {
        super.setDescription(description);
    }

    public void setDestination(Space space){
        this.destination = space;
    }

    @Override
    public void landOn(Player player) {
        player.setSpace(destination);
    }
}
