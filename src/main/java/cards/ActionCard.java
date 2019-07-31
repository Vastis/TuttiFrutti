package cards;

public class ActionCard extends Card {
    enum actionName {
        COMMANDER,
        REINFORCEMENTS,
        SQUIRE,
        MUD,
        FOG,
        DESERTER,
        TRAITOR,
        SCOUT,
        REGROUP
    }

    enum actionCategory {
        TERRAIN,
        MORALE,
        SPECIAL
    }

    private actionCategory category;
    private actionName name;

    public ActionCard(cardType type, actionCategory category, actionName name) {
        super(type);
        this.category = category;
        this.name = name;
    }

}
