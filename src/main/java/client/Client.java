package client;

import utils.FileReader;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client extends Thread {

    private static int id = 0;
    private int uid;
    private String serverIP;
    private int serverPort;
    private FileReader reader;

    public Client(){
        this.reader = new FileReader("config");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
