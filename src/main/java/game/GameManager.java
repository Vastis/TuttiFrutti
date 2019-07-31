package game;

import connection.Server;
import connection.SocketManager;

import java.io.IOException;
import java.util.Random;

public class GameManager extends Server {

    private boolean running = false;
    private AppState state = AppState.IDLE;
    private SocketManager playerMoving, playerWaiting;

    public GameManager() {
        super(2);
    }

    @Override
    public void run(){
        super.run();
        this.state = AppState.INIT;
        this.running = true;
        while(this.running){
            switch(this.state){
                case IDLE:
                    break;
                case INIT:
                    choosePlayersOrder();
                    Game.getInstance().start();
                    this.state = AppState.RUNNING;
                    break;
                /*case PAUSED:
                    Game.getInstance().pause();
                    break;
                case RESUMED:
                    Game.getInstance().resume();
                    break;*/
                case RUNNING:
                    try {
                        String playerResponse = manageResponse();
                        Game.getInstance().run(playerResponse);
                        swapPlayers();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case STOPPED:
                    Game.getInstance().stop();
                    this.running = false;
                    break;
                case RESTARTED:
                    Game.getInstance().stop();
                    Game.getInstance().start();
                    break;
            }
        }
    }

    private String manageResponse() throws IOException {
        //TODO
        return "";
    }

    private void choosePlayersOrder() {
        Random random = new Random();
        int playerMovingIndex = random.nextInt(2);
        this.playerMoving = this.clients.get(playerMovingIndex);
        this.playerWaiting = this.clients.get(1 - playerMovingIndex);
    }

    private void swapPlayers(){
        SocketManager tmp = this.playerWaiting;
        this.playerWaiting = this.playerMoving;
        this.playerMoving = tmp;
    }

    public void setState(AppState state) {
        this.state = state;
    }
}
