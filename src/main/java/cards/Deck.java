package cards;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private Card.cardType type;
    private LinkedList<Card> cards = new LinkedList<>();

    public Deck(Card.cardType type) {
        this.type = type;
        this.setDeck();
    }

    private void setDeck() {
        switch (this.type) {
            case CLAN:
                for (ClanCard.cardColor color : ClanCard.cardColor.values()) {
                    for (int value = 1; value <= 9; ++value) {
                        this.cards.add(new ClanCard(Card.cardType.CLAN, color, value));
                    }
                }
                break;
            case ACTION:
                for (ActionCard.actionCategory category : ActionCard.actionCategory.values()) {
                    switch (category){
                        case MORALE:
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "SQUIRE"));
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "REINFORCEMENTS"));
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "COMMANDER"));
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "COMMANDER"));
                            break;
                        case SPECIAL:
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "REGROUP"));
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "SCOUT"));
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "TRAITOR"));
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "DESERTER"));
                            break;
                        case TERRAIN:
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "MUD"));
                            this.cards.add(new ActionCard(Card.cardType.ACTION, category, "FOG"));
                            break;
                    }
                }
                break;
            case STONE:
                for (int i = 1; i <= 9; ++i) {
                    this.cards.add(new StoneCard(Card.cardType.STONE));
                }
            default:
                System.out.println("Type of deck is not defined");
        }
        this.shuffle();
    }

    private void shuffle() {
        Collections.shuffle(this.cards);
    }

    public LinkedList<Card> getCards() {
        return cards;
    }
}
