import game.GameManager;
import game.Player;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            new Player().start();
        } catch (IOException e) {
            new GameManager().start();
            new Player().start();
        }
    }
}