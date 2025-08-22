package edu.kit.kastel.classTree;

import edu.kit.kastel.structure.Ladybug;

public class ParallelNode extends InnerNode {

    ParallelNode(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    boolean perform(Ladybug ladybug, int... args) {
        int counter = 0;
        for (Node child : children) {
            if (child.perform(ladybug)) {
                counter++;
            }
        }
        if (counter >= args[0]) {
            return true;
        } else {
            return false;
        }
    }

}
