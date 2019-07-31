package game;

import cards.StoneSlot;

public class Game {

    private static Game game;
    private StoneSlot[] stones;

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

    public void run(String msg){
        //TODO
    }

    public void stop(){
        game = null;
    }
}
