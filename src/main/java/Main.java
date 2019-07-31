import cards.ActionCard;
import cards.Card;
import cards.ClanCard;
import communication.DealCardsWrapper;
import communication.FrameWrapper;
import communication.OrderAssignmentWrapper;
import game.GameManager;
import game.Player;
import utils.JsonParser;

import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        FrameWrapper fw = new JsonParser<>(FrameWrapper.class).fromFile("tmp.json");
        fw.print();

        String type = "DEAL_CARDS";
        LinkedList<Card> cards = new LinkedList<>();
        cards.add(new ClanCard(Card.cardType.CLAN, ClanCard.cardColor.BROWN, 4));
        cards.add(new ActionCard(Card.cardType.ACTION, ActionCard.actionCategory.TERRAIN, "typo"));
        cards.add(new ClanCard(Card.cardType.CLAN, ClanCard.cardColor.RED, 3));
        cards.add(new ClanCard(Card.cardType.CLAN, ClanCard.cardColor.RED, 2));
        cards.add(new ActionCard(Card.cardType.ACTION, ActionCard.actionCategory.TERRAIN, "typo"));
        cards.add(new ClanCard(Card.cardType.CLAN, ClanCard.cardColor.GREEN, 7));
        cards.add(new ClanCard(Card.cardType.CLAN, ClanCard.cardColor.GREEN, 1));
        DealCardsWrapper wrapper = new DealCardsWrapper(cards);

        //OrderAssignmentWrapper wrapper = new OrderAssignmentWrapper(12);
        FrameWrapper frameWrapper = new FrameWrapper(type, wrapper);

        String json = new JsonParser<>(FrameWrapper.class).toJson(frameWrapper);
        json = FrameWrapper.normalize(json);
        System.out.println(json);

        FrameWrapper fw2 = new JsonParser<>(FrameWrapper.class).toJsonObject(json);
        fw2.print();
        /*try {
            new Player().start();
        } catch (IOException e) {
            new GameManager().start();
            new Player().start();
        }*/
    }
}