package edu.kit.kastel.tree;

import edu.kit.kastel.structure.*;

public enum ConditionType implements TreeNode {

    LEAFFRONT("leafFront") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.isLeafFront();
        }
    },
    TREEFRONT("treeFront") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.isTreeFront();
        }
    },
    MUSHROOMFRONT("mushroomFront") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.isMushroomFront();
        }
    },
    ATEDGE("atEdge") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.isAtEdge();
        }
    },
    EXISTSPath("existsPath") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            if (args.length == 2) {
                return false;
            } else if (args.length == 4) {
                return false;
            } else {
                return false;
            }
        }
    };

    private String name;

    ConditionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
