package communication;

public enum FrameType {

    ORDER_ASSIGNMENT(0),
    DEAL_CARDS(1);

    private int id;

    FrameType(int id){
        this.id = id;
    }
}
