package edu.kit.kastel.tree;

import java.util.LinkedList;
import java.util.List;

public enum InnerNode implements TreeNode {
    FALLBACK("fallback") {
        @Override
        public boolean perform() {
            for (int i = 0; i < children.size(); i++) {
                children.get(i).
            }
            return true;
        }
    },
    PARALLEL("parallel") {
        @Override
        public boolean perform() {
            return true;
        }
    },
    SEQUENCE("sequence") {
        @Override
        public boolean perform() {
            return true;
        }
    };

    protected List<TreeNode> children = new LinkedList<>();
    private String name;

    InnerNode(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    abstract boolean perform();
}
