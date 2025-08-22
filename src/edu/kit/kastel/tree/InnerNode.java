package edu.kit.kastel.tree;

import edu.kit.kastel.structure.Ladybug;

import java.util.List;

public enum InnerNode implements TreeNode {

    FALLBACK("?") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return true;
        }
    },
    SEQUENCE("->") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return true;
        }
    },
    PARALLEL("=%s>") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return true;
        }
    };

    private String symbol;

    private List<TreeNode> children;

    InnerNode(String symbol) {
        this.symbol = symbol;
    }

    
}
