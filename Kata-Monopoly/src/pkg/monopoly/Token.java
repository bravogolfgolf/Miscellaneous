package pkg.monopoly;

public class Token {

    private String description;
    private int location;

    public Token(String description) {
        this.description = description;
        this.location = 0;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return location == token.location && (description != null ? description.equals(token.description) : token.description == null);
    }

    @Override
    public int hashCode() {
        int result = location;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
