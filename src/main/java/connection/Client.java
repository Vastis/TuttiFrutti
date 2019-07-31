package connection;

import utils.FileReader;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    private Socket socket;
    protected SocketManager socketManager;

    public Client() throws IOException {
        FileReader reader = new FileReader("config");
        String serverIP = reader.getScanner().nextLine();
        int serverPort = reader.getScanner().nextInt();
        this.socket = new Socket(serverIP, serverPort);
    }

    @Override
    public void run(){
        try {
            this.socketManager = new SocketManager(this.socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SocketManager getSocketManager() {
        return this.socketManager;
    }
}
