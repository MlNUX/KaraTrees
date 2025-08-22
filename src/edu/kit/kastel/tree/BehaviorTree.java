package edu.kit.kastel.tree;

import edu.kit.kastel.structure.*;

public class BehaviorTree {

    private TreeNode root;
    private Ladybug ladybug;

    public BehaviorTree(Ladybug ladybug) {
        root = null;
        this.ladybug = ladybug;
    }

    public TreeNode getRoot() {
        return root;
    }

}
