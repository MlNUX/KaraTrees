package edu.kit.kastel.classTree;

import edu.kit.kastel.structure.Ladybug;

public abstract class Node {

    String name;

    String symbol;

    Node(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    abstract boolean perform(Ladybug ladybug, int... args);
}
