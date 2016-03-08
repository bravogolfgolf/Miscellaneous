package pkg.monopoly;

public class OwnershipMultiplier {
    private final boolean aDefault;
    private final int value;

    public OwnershipMultiplier(int value) {
        this.value = value;
        this.aDefault = false;
    }

    public OwnershipMultiplier() {
        this.value = 1;
        this.aDefault = true;
    }

    public int value() {
        return value;
    }

    public boolean isDefault() {
        return aDefault;
    }
}
