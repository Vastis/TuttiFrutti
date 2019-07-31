package cards;

import actions.*;
import communication.ContentWrapper;

public class ActionCard extends Card implements ContentWrapper {
    public enum actionCategory {
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
        switch (this.name){
            case "Commander":
                return new Commander();
            case "Deserter":
                return new Deserter();
            case "Fog":
                return new Fog();
            case "Mud":
                return new Mud();
            case "Regroup":
                return new Regroup();
            case "Reinforcements":
                return new Regroup();
            case "Scout":
                return new Scout();
            case "Squire":
                return new Squire();
            case "Traitor":
                return new Traitor();
        }
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
    @Override
    public void print() {
        System.out.println(this.category + " " + this.name + " " + this.getType());
    }
    @Override
    public void initialize() throws NullPointerException {}
}
