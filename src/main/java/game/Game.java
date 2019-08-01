package game;

import communication.FrameWrapper;

public class Game {

    private static Game game;

    private Game(){}

    public static Game getInstance(){
        if(game == null)
            game = new Game();
        return game;
    }

    public void start(){
        generateCards();
        shuffleCards();
        dealFirstSix();
    }
    private void generateCards() {
        //TODO
    }
    private void shuffleCards() {
        //TODO
    }
    private void dealFirstSix() {
        //TODO
    }

    public void run(FrameWrapper msg){
        msg.print();
    }

    public void stop(){
        game = null;
    }
}
