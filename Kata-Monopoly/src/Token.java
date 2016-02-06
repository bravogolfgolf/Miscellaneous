public class Token {

    private String token = "";
    private int location;


    public Token(String token) {
        this.token = token;
        this.location = 0;
    }

    public String getTokenDescription() {
        return token;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
