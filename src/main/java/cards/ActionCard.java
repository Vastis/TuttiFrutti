package cards;

import actions.Action;

public class ActionCard extends Card {
    enum actionCategory {
        TERRAIN,
        MORALE,
        SPECIAL
    }

    private actionCategory category;
    private String name;

    private Action action;

    public ActionCard(cardType type, actionCategory category, String name) {
        super(type);
        this.category = category;
        this.name = name;
        this.action = initAction();
    }

    private Action initAction() {
        //TODO
        return null;
    }

    public actionCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Action getAction(){
        return this.action;
    }
}
