package edu.kit.kastel.tree;

public class Leave {

    private ConditionType type;

    public Leave(ConditionType type) {
        this.type = type;
    }

    public String perform() {
        type.perform();
    }
}
