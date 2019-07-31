package communication;

public class OrderAssignmentWrapper extends ContentWrapper {
    private int order;

    public OrderAssignmentWrapper(){}
    public OrderAssignmentWrapper(int order){
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public void print() {
        System.out.println("Order: " + order);
    }

    @Override
    public void initialize() throws NullPointerException {

    }
}
