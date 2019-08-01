package game;

import cards.Card;
import cards.Deck;
import cards.StoneCard;

public class Game {

    private static Game game;
    private Deck actionDeck, clanDeck;
    private StoneCard[] stones = new StoneCard[9];

    private Game(){}

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
            stones[i] = new StoneCard(Card.cardType.STONE);
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

    public void run(String msg){
        //TODO
    }

    public void stop(){
        game = null;
    }
}
