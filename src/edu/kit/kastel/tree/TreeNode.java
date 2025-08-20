package edu.kit.kastel.tree;

import edu.kit.kastel.structure.Ladybug;

@FunctionalInterface
public interface TreeNode {

    boolean perform(Ladybug ladybug, int... args);
}
