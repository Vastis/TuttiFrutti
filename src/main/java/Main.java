import game.GameManager;
import game.Player;
import cards.ActionCard;
import cards.Card;
import cards.ClanCard;
import cards.Deck;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            new Player().start();
        } catch (IOException e) {
            new GameManager().start();
            new Player().start();
        }
        Deck actionDeck = new Deck(Card.cardType.ACTION);
        Deck clanDeck = new Deck(Card.cardType.CLAN);
        Deck stoneDeck = new Deck(Card.cardType.STONE);
    }
}