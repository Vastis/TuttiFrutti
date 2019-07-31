package cards;

import communication.ContentWrapper;

public class ClanCard extends Card implements ContentWrapper {
    public enum cardColor {
        RED,
        BLUE,
        PURPLE,
        YELLOW,
        GREEN,
        BROWN
    }

    private cardColor color;
    private int value;


    public ClanCard(cardType type, cardColor color, int value) {
        super(type);
        this.color = color;
        this.value = value;
    }

    public cardColor getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void print() {
        System.out.println(this.color + " " + this.value + " " + this.getType());
    }
    @Override
    public void initialize() throws NullPointerException {}
}
