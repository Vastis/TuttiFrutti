package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client extends Thread {

    private static int id = 0;
    private int uid;
    private String serverIP;
    private int serverPort;

    public Client(){
        this.readConnectionConfig();
        this.uid = ++id;
    }

    private void readConnectionConfig(){
        File file = new File(getClass().getClassLoader().getResource("config").getFile());
        try {
            Scanner scanner = new Scanner(file);
            this.serverIP = scanner.nextLine();
            this.serverPort = scanner.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
