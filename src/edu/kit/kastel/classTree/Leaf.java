package edu.kit.kastel.classTree;

import edu.kit.kastel.structure.Ladybug;

public class Leaf extends Node {

    LeafType leafType;

    Leaf(String name, String symbol, LeafType leafType) {
        super(name, symbol);
        this.leafType = leafType;
    }

    public LeafType getLeafType() {
        return leafType;
    }


    @Override
    boolean perform(Ladybug ladybug, int... args) {
        return leafType.perform(ladybug, args);
    }
}
