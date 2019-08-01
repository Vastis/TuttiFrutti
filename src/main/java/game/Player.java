package game;

import cards.ActionCard;
import cards.Card;
import cards.ClanCard;
import communication.FrameManager;
import connection.Client;
import gui.ClientWindow;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Player extends Client {

    private ClientWindow window;

    public Player() throws IOException {
        super();
        initWindow();
    }
    private void initWindow() {
        //TODO
    }

    //tmp
    @Override
    public void run(){
        super.run();
        int i = 0;
        Random random = new Random();
        while(true){
            String msg = "";
            switch (i){
                case 0:
                    msg = FrameManager.createOrderAssignmentFrame(random.nextInt());
                    break;
                case 1:
                    LinkedList<Card> cards = new LinkedList<>();
                    int quantity = random.nextInt(10) + 1;
                    for(int x = 0; x < quantity; x++){
                        if(random.nextBoolean()) {
                            int cardColorIndex = random.nextInt(ClanCard.cardColor.values().length);
                            cards.add(new ClanCard(Card.cardType.CLAN, ClanCard.cardColor.values()[cardColorIndex], random.nextInt(9) + 1));
                        } else {
                            int actionCategoryIndex = random.nextInt(ActionCard.actionCategory.values().length);
                            cards.add(new ActionCard(Card.cardType.ACTION, ActionCard.actionCategory.values()[actionCategoryIndex], "costam"));
                        }

                    }
                    msg = FrameManager.createDealCardsFrame(cards);
                    i = 0;
                    break;
            }
            i = random.nextInt(2);
            this.socketManager.write(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
