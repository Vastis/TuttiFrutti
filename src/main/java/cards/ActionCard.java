package cards;

import communication.ContentWrapper;

public class ActionCard extends Card implements ContentWrapper {
    public enum actionCategory {
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

    @Override
    public void print() {
        System.out.println(this.category + " " + this.name + " " + this.getType());
    }
    @Override
    public void initialize() throws NullPointerException {}
}
