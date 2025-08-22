package edu.kit.kastel.classTree;

import edu.kit.kastel.structure.Ladybug;

public class SequenceNode extends InnerNode {
    SequenceNode(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    boolean perform(Ladybug ladybug, int... args) {
        for (Node child : children) {
            if (!child.perform(ladybug)) {
                return false;
            }
        }
        return true;
    }
}
