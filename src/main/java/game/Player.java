package game;

import connection.Client;
import gui.ClientWindow;

import java.io.IOException;

public class Player extends Client {

    private ClientWindow window;

    public Player() throws IOException {
        super();
        initWindow();
    }

    private void initWindow() {
        //TODO
    }
}
