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
        if (value >= 1 && value <= 9) {
            this.value = value;
        }
        else {
            System.out.println("Value does not fall within the expected range");
        }
    }

    public cardColor getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
}
