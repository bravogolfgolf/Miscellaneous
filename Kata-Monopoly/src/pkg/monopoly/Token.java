package pkg.monopoly;

public enum Token {

    Boot("Boot","(B)oot","B"),
    Car("Race car","(R)ace car","R"),
    Cat("Cat","(C)at","C"),
    Dog("Dog","(D)og","D"),
    Hat("Top hat","Top (h)at","H"),
    Ship("Battleship","Battle(s)hip","S"),
    Thimble("Thimble","(T)himble","T"),
    Wheelbarrow("Wheelbarrow","(W)heelbarrow","W");

    private final String description;
    private final String menuString;
    private final String tokenLetter;

    Token(final String description, final String menuString, final String tokenLetter) {
        this.description = description;
        this.menuString = menuString;
        this.tokenLetter = tokenLetter;
    }

    public String getMenuString() {
        return menuString;
    }

    public String getDescription() {
        return description;
    }

    public String getTokenLetter() {
        return  tokenLetter;
    }
}
