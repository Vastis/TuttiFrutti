import communication.FrameWrapper;
import communication.OrderAssignmentWrapper;
import game.GameManager;
import game.Player;
import utils.JsonParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FrameWrapper fw = new JsonParser<>(FrameWrapper.class).fromFile("tmp.json");
        fw.print();

        String type = "ORDER_ASSIGNMENT";
        int order = 12;

        OrderAssignmentWrapper wrapper = new OrderAssignmentWrapper(12);
        FrameWrapper frameWrapper = new FrameWrapper(type, wrapper);

        String json = new JsonParser<>(FrameWrapper.class).toJson(frameWrapper);
        System.out.println(json);
        /*try {
            new Player().start();
        } catch (IOException e) {
            new GameManager().start();
            new Player().start();
        }*/
    }
}