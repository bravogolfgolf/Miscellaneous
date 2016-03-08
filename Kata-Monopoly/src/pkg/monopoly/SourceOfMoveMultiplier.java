package pkg.monopoly;

public class SourceOfMoveMultiplier {
    private final boolean generic;
    private final int value;

    public SourceOfMoveMultiplier(int value) {
        this.value = value;
        this.generic = false;
    }

    public SourceOfMoveMultiplier() {
        this.value = 1;
        this.generic = true;
    }

    public int value() {
        return value;
    }

    public boolean isDefault() {
        return generic;
    }
}
