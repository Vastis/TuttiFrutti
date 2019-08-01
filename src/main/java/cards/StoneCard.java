package cards;

import java.util.HashSet;
import java.util.LinkedList;

public class StoneCard extends Card {
    private LinkedList<Card> player1 = new LinkedList<>();
    private LinkedList<Card> player2 = new LinkedList<>();
    private LinkedList<ActionCard> terrainCards = new LinkedList<>();

    public StoneCard(cardType type) {
        super(type);
    }

    @Override
    public void print() { }
}
