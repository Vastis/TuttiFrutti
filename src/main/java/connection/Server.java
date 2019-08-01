package connection;

import utils.FileReader;
import utils.Log;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends Thread {

    private int clientsAvailable, port;
    private ServerSocket socket;
    protected ArrayList<SocketManager> clients;

    public Server(int clientsAvailable) {
        readPort();
        this.clientsAvailable = clientsAvailable;
        this.clients = new ArrayList<>();
    }
    private void readPort() {
        FileReader reader = new FileReader("config");
        reader.getScanner().nextLine();
        this.port = reader.getScanner().nextInt();
    }

    @Override
    public void run(){
        super.run();
        try {
            this.socket = new ServerSocket(this.port);
            awaitConnections();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void awaitConnections() throws IOException {
        /*for(int i = 1; i <= this.clientsAvailable; i++){
            Log.write("Waiting for player " + i);
            this.clients.add(new SocketManager(socket.accept()));
        }*/
        /*tmp*/this.clients.add(new SocketManager(socket.accept()));
    }
}
