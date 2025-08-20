package edu.kit.kastel.tree;

import edu.kit.kastel.structure.*;

public enum ConditionType implements TreeNode {

    LEAFFRONT("leafFront") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.isLeafFront();
        }
    },
    TREEFRONT("treeFront") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.isTreeFront();
        }
    },
    MUSHROOMFRONT("mushroomFront") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.isMushroomFront();
        }
    },
    ATEDGE("atEdge") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.isAtEdge();
        }
    },
    EXISTSPath("existsPath") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return false;
        }

        @Override
        public boolean perform(int x, int y) {

        }

        @Override
        public boolean perform(int x1, int y1, int x2, int y2) {

        }
    };

    private String name;

    ConditionType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    abstract boolean perform(Ladybug ladybug);

    boolean perform(int x, int y) {
        return false;
    }

    boolean perform(int x1, int y1, int x2, int y2) {
        return false;
    }
}
