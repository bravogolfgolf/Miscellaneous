package pkg.monopoly;

public enum Token {

    Cat("Cat","(C)at"),
    Dog("Dog","(D)og"),
    Car("Race car","(R)ace car"),
    Thimble("Thimble","(T)himble"),
    Boot("Boot","(B)oot"),
    Ship("Battleship","(B)attleship"),
    Hat("Top hat","Top (h)at"),
    Wheelbarrow("Wheelbarrow","(W)heelbarrow");

    private final String description;
    private final String menuString;

    Token(final String description, final String menuString) {
        this.description = description;
        this.menuString = menuString;
    }

    public String getMenuString() {
        return menuString;
    }

    public String getDescription() {
        return description;
    }
}
