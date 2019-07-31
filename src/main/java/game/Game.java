package game;

public class Game {

    private static Game game;

    private Game(){
        initGameParts();
    }
    public static Game getInstance(){
        if(game == null)
            game = new Game();
        return game;
    }

    private void initGameParts() {
        //TODO
    }

    public void start(){

    }
    public void run(String msg){

    }
    public void stop(){
        game = null;
    }
    public void pause(){

    }
    public void resume(){

    }
    /*System.out.println("ready");
        for(SocketManager c : this.clients){
            Log.write("Server: Hi!");
            c.write("Hi!");
            Log.write("Client: " + c.read());
        }*/
}
