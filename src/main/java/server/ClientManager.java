package server;

import utils.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManager {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public ClientManager(Socket socket) throws IOException {
        this.socket = socket;
        this.writer = new PrintWriter(socket.getOutputStream(), true);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void write(String msg){
        this.writer.println(msg);
    }

    public String read() throws IOException {
        return this.reader.readLine();
    }
}
