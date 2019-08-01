package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketManager {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private NetworkListener listener;

    public SocketManager(Socket socket) throws IOException {
        this.socket = socket;
        this.writer = new PrintWriter(socket.getOutputStream(), true);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.listener = new NetworkListener(this);
    }

    public void write(String msg){
        this.writer.println(msg);
    }

    public String read() throws IOException {
        return this.reader.readLine();
    }

    public NetworkListener getListener() {
        return listener;
    }
}
