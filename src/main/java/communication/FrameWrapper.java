package communication;

import utils.JsonParser;
import utils.Wrapper;

public class FrameWrapper implements Wrapper {
    private String frameType;
    private Object content;
    private ContentWrapper contentWrapper;
    private Class<? extends ContentWrapper> contentWrapperClass;

    public FrameWrapper(){}
    public FrameWrapper(String frameType, ContentWrapper contentWrapper){
        this.frameType = frameType;
        this.contentWrapper = contentWrapper;
    }

    @Override
    public void initialize() throws NullPointerException {
        FrameType type = FrameType.valueOf(this.frameType);
        switch (type){
            case ORDER_ASSIGNMENT:
                this.contentWrapperClass = OrderAssignmentWrapper.class;
                this.contentWrapper = new JsonParser<>(OrderAssignmentWrapper.class)
                        .toJsonObject(this.content.toString());
                break;
            case DEAL_CARDS:
                this.contentWrapperClass = DealCardsWrapper.class;
                this.contentWrapper = new JsonParser<>(DealCardsWrapper.class)
                        .toJsonObject(this.content.toString());
                break;
        }
    }

    public static String normalize(String json){
        return json
                .replace("contentWrapper", "content")
                .replace("convertedCards", "cards");
    }

    public void print(){
        System.out.println("Type: " + frameType);
        System.out.println("Type: " + contentWrapperClass);
        this.contentWrapper.print();
    }

    public String getFrameType() {
        return this.frameType;
    }
    public Class<? extends ContentWrapper> getContentWrapperClass() {
        return this.contentWrapperClass;
    }
    public ContentWrapper getContentWrapper() {
        return this.contentWrapper;
    }
}
