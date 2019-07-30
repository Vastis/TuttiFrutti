package server;

import utils.Log;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends Thread {
    //tmp
    private int port;
    private ServerSocket socket;
    private ArrayList<ClientManager> clients;

    public Server(int port) throws IOException {
        this.port = port;
        this.socket = new ServerSocket(this.port);
        this.clients = new ArrayList<>();
    }

    @Override
    public void run(){
        super.run();
        try {
            awaitConnections();
            startTheGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void awaitConnections() throws IOException {
        Log.write("Waiting for player 1");
        this.clients.add(new ClientManager(socket.accept()));
        Log.write("Waiting for player 2");
        this.clients.add(new ClientManager(socket.accept()));
    }

    private void startTheGame() throws IOException {
        System.out.println("ready");
        for(ClientManager c : this.clients){
            Log.write("Server: Hi!");
            c.write("Hi!");
            Log.write("Client: " + c.read());
        }
    }
}
