package cards;

public abstract class Card {
    public enum cardType {
        STONE,
        CLAN,
        ACTION
    }

    private cardType type;

    public Card(cardType type) {
        this.type = type;
    }

    public cardType getType() {
        return type;
    }

    public abstract void print();

}
