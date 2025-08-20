package edu.kit.kastel.tree;

import edu.kit.kastel.structure.Ladybug;

import java.util.LinkedList;
import java.util.List;

public enum InnerNode implements TreeNode {
    FALLBACK("fallback") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            for (TreeNode child : children) {
                if (child.perform(ladybug, args)) {
                    return true;
                }
            }
            return false;
        }
    },
    PARALLEL("parallel") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            int count = 0;
            for (TreeNode child : children) {
                if (child.perform(ladybug, args)) {
                    count++;
                }
            }
            return count >= args[0];
        }
    },
    SEQUENCE("sequence") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            for (TreeNode child : children) {
                if (!child.perform(ladybug, args)) {
                    return false;
                }
            }
            return true;
        }
    };

    protected List<TreeNode> children = new LinkedList<>();
    private String name;

    InnerNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
}
