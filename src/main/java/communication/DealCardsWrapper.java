package communication;

import cards.ClanCard;
import java.util.LinkedList;

public class DealCardsWrapper extends ContentWrapper {
    LinkedList<ClanCard> cards;

    public DealCardsWrapper(){}
    public DealCardsWrapper(LinkedList<ClanCard> cards){
        this.cards = new LinkedList<>();
        this.cards.addAll(cards);
    }

    @Override
    public void print() {
        cards.forEach(c -> System.out.println(c.getColor() + " " + c.getValue() + " " + c.getType()));
    }

    @Override
    public void initialize() throws NullPointerException {

    }
}
