import cards.ActionCard;
import cards.Card;
import cards.ClanCard;
import cards.Deck;
import client.Client;
import server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            new Server(6789).start();
            new Client().start();
            new Client().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Deck actionDeck = new Deck(Card.cardType.ACTION);
        Deck clanDeck = new Deck(Card.cardType.CLAN);
        Deck stoneDeck = new Deck(Card.cardType.STONE);


    }
}