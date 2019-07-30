package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {

    private static int id = 0;
    private int uid;
    private String ip = "localhost";
    private int port = 6789;

    public Client(){
        this.uid = ++id;
    }

    @Override
    public void run(){
        try {
            Socket socket = new Socket(ip, port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println(reader.readLine() + " I'm player " + uid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
