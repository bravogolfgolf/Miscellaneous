package pkg.monopoly;

public class PlayerMockManagePropertiesCounter extends Player {

    public int manageProperties = 0;

    public PlayerMockManagePropertiesCounter() {
        super("PlayerMockManagePropertiesCounter");
    }

    @Override
    public void manageProperties() {
        manageProperties++;
    }

}