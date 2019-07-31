package cards;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    enum deckType {
        ACTION,
        CLAN
    }

    private deckType type;
    private LinkedList<Card> cards;

    public Deck(deckType type) {
        this.type = type;
    }

    private void shuffle() {
        Collections.shuffle(this.cards);
    }

}
