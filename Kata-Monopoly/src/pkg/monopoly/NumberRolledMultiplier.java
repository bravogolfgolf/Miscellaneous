package pkg.monopoly;

public class NumberRolledMultiplier {
    private final boolean aDefault;
    private final int value;

    public NumberRolledMultiplier(int value) {
        this.value = value;
        this.aDefault = false;
    }

    public NumberRolledMultiplier() {
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
