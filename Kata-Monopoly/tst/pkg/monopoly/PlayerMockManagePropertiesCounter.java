package pkg.monopoly;

public class PlayerMockManagePropertiesCounter extends Player {

    public int manageProperties = 0;

    public PlayerMockManagePropertiesCounter() {
        super();
    }

    @Override
    public void manageProperties() {
        manageProperties++;
    }

}