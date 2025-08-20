package edu.kit.kastel.tree;

import edu.kit.kastel.structure.*;

public class BehaviorTree {

    private TreeNode root;
    private Ladybug ladybug;
    private TreeNode current;

    public BehaviorTree(Ladybug ladybug) {
        root = null;
        this.ladybug = ladybug;
        current = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getCurrent() {
        return current;
    }

    public void reset() {
        current = root;
    }

}
