package pkg.monopoly;

public enum Token {

    Boot("Boot","(B)oot"),
    Car("Race car","(R)ace car"),
    Cat("Cat","(C)at"),
    Dog("Dog","(D)og"),
    Hat("Top hat","Top (h)at"),
    Ship("Battleship","(B)attleship"),
    Thimble("Thimble","(T)himble"),
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
