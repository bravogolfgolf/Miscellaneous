package pkg.monopoly;

public class Basis {
    private final boolean aDefault;
    private final int value;

    public Basis(int value) {
        this.value = value;
        this.aDefault = false;
    }

    public Basis() {
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
