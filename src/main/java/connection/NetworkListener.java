package connection;

import communication.FrameManager;

import java.io.IOException;

public class NetworkListener extends Thread {

    private SocketManager socketManager;

    public NetworkListener(SocketManager socketManager){
        this.socketManager = socketManager;
    }

    @Override
    public void run(){
        while(true){
            try {
                String msg = this.socketManager.read().trim();
                FrameManager.decode(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
