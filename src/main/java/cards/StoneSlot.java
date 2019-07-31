package cards;

import java.util.LinkedList;

public class StoneSlot extends Card {
    private LinkedList<Card> player1 = new LinkedList<>();
    private LinkedList<Card> player2 = new LinkedList<>();
    private LinkedList<ActionCard> terrainCards = new LinkedList<>();
    private boolean ifTaken;

    public StoneSlot(cardType type) {
        super(type);
        ifTaken = false;
    }

}
