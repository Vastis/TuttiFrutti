package cards;

public class ActionCard extends Card {
    enum actionCategory {
        TERRAIN,
        MORALE,
        SPECIAL
    }

    private actionCategory category;
    private String name;

    public ActionCard(cardType type, actionCategory category, String name) {
        super(type);
        this.category = category;
        this.name = name;
    }

    public actionCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
