package communication;

import cards.ActionCard;
import cards.Card;
import cards.ClanCard;
import utils.JsonParser;

import java.util.LinkedList;

public class DealCardsWrapper implements ContentWrapper {
    LinkedList<Object> cards;
    LinkedList<Card> convertedCards;

    public DealCardsWrapper(){}
    public DealCardsWrapper(LinkedList<Card> cards){
        this.convertedCards = new LinkedList<>();
        this.convertedCards.addAll(cards);
    }

    @Override
    public void initialize() throws NullPointerException {
        this.convertedCards = new LinkedList<>();
        this.cards.forEach(c -> {
            if(c.toString().contains(Card.cardType.CLAN.name())) {
                this.convertedCards.add(
                        new JsonParser<>(ClanCard.class)
                        .toJsonObject(c.toString()));
            } else {
                this.convertedCards.add(
                        new JsonParser<>(ActionCard.class)
                        .toJsonObject(c.toString()));
            }
        });
    }

    @Override
    public void print() {
        this.convertedCards.forEach(c -> c.print());
    }
}
