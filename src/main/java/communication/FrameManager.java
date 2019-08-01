package communication;

import cards.Card;
import utils.JsonParser;

import java.util.LinkedList;

public class FrameManager {

    public static FrameWrapper decode(String msg) {
        return new JsonParser<>(FrameWrapper.class).toJsonObject(msg);
    }

    public static String createOrderAssignmentFrame(int order){
        String type = "ORDER_ASSIGNMENT";
        OrderAssignmentWrapper wrapper = new OrderAssignmentWrapper(order);
        return prepareJson(type, wrapper);
    }

    public static String createDealCardsFrame(LinkedList<Card> cards){
        String type = "DEAL_CARDS";
        DealCardsWrapper wrapper = new DealCardsWrapper(cards);
        return prepareJson(type, wrapper);
    }

    private static String prepareJson(String type, ContentWrapper wrapper) {
        FrameWrapper frameWrapper = new FrameWrapper(type, wrapper);
        String json = new JsonParser<>(FrameWrapper.class).toJson(frameWrapper);
        json = FrameWrapper.normalize(json);
        return json;
    }
}
