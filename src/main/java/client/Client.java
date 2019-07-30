package client;

import utils.FileReader;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    private static int id = 0;
    private int uid;
    private String serverIP;
    private int serverPort;

    public Client() {
        FileReader reader = new FileReader("config");

        this.serverIP = reader.getScanner().nextLine();
        this.serverPort = reader.getScanner().nextInt();
        this.uid = ++id;
    }

    @Override
    public void run(){
        try {
            Socket socket = new Socket(this.serverIP, this.serverPort);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println(reader.readLine() + " I'm player " + uid);
            System.out.println(this.serverIP);
            System.out.println(this.serverPort);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
