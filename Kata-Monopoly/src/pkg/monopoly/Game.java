package pkg.monopoly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Game {

    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Game(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
        write("How many player (2-8)?");

    }

    private void write(String s) throws IOException {
        writer.write(s,0,s.length());
        writer.flush();
    }
}
