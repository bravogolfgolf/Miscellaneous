package pkg.monopoly;

public class OwnershipMultiplier {
    private final boolean generic;
    private final int value;

    public OwnershipMultiplier(int value) {
        this.value = value;
        this.generic = false;
    }

    public OwnershipMultiplier() {
        this.value = 1;
        this.generic = true;
    }

    public int value() {
        return value;
    }

    public boolean isDefault(){
        return generic;
    }
}
