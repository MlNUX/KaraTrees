package edu.kit.kastel.tree;

import edu.kit.kastel.structure.*;

public class BehaviorTree {

    private Node root;
    private Ladybug ladybug;

    public BehaviorTree(Ladybug ladybug) {
        root = null;
        this.ladybug = ladybug;
    }

    public Node getRoot() {
        return root;
    }

}
