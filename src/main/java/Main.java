import client.Client;
import server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            new Server(6789).start();
            new Client().start();
            new Client().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}