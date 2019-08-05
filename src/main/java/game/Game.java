package game;

import cards.StoneSlot;
import communication.FrameWrapper;
import cards.Card;
import cards.Deck;

public class Game {

    private static Game game;
    private StoneSlot[] stones;
    private Deck actionDeck, clanDeck;

    private Game(){
        this.stones = new StoneSlot[9];
    }

    public static Game getInstance(){
        if(game == null)
            game = new Game();
        return game;
    }

    public void start(){
        generateCards();
        dealFirstSix();
    }
    private void generateCards() {
        actionDeck = new Deck(Card.cardType.ACTION);
        clanDeck = new Deck(Card.cardType.CLAN);
        for (int i = 0; i < 9; ++i) {
            stones[i] = new StoneSlot(Card.cardType.STONE);
        }
    }
    private void dealFirstSix() {
        for (int i = 1; i <= 6; ++i) {
//            deal(player1, Card.cardType.CLAN);
//            deal(player2, Card.cardType.CLAN);
        }
    }
    private void deal(Player player, Card.cardType type) {
        //TODO
    }

    public void run(FrameWrapper msg){
        msg.print();
    }

    public void stop(){
        game = null;
    }
}
