package client;

import utils.FileReader;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    private static int id = 0;
    private int uid;
    private String serverIP;
    private int serverPort;

    public Client() {
        FileReader reader = new FileReader("config");
        try {
            reader.setScanner(new Scanner(reader.getFile()));
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file: " + reader.getFile());
        }
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
