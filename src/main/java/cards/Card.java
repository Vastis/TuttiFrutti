package cards;

public  class Card {
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

}
