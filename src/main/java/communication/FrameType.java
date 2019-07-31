package communication;

public enum FrameType {

    ORDER_ASSIGNMENT(0);

    private int id;

    FrameType(int id){
        this.id = id;
    }
}
