package pkg.monopoly;

public enum Token {

    Cat("(C)at"),
    Dog("(D)og"),
    Racecar("(R)acecar");


    private final String menuString;
    
    Token(final String menuString) {
        this.menuString = menuString;
    }

    public String getMenuString() {
        return menuString;
    }
}
