package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
    private String serverIP;
    private int serverPort;

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

    public Client(){
        this.readConnectionConfig();
    }

    @Override
    public void run(){
        try {
            Socket socket = new Socket(this.serverIP, this.serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
