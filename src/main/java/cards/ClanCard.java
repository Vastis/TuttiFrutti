package cards;

public class ClanCard extends Card {
    enum cardColor {
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


}
