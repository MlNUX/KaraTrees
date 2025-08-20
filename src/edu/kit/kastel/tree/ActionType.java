package edu.kit.kastel.tree;

import edu.kit.kastel.structure.Ladybug;

public enum ActionType implements TreeNode {

    TURNLEFT("turnLeft") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.turnLeft();
        }
    },

    TURNRIGHT("turnRight") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.turnRight();
        }
    },

    PLACELEAF("placeLeaf") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.placeLeaf();
        }
    },

    TAKELEAF("takeLeaf") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.takeLeaf();
        }
    },

    MOVE("move") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.move();
        }
    },

    FLY("fly") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            if (args.length == 2) {
                return ladybug.fly(args[0], args[1]);
            } else {
                return false;
            }
        }
    };

    private String name;

    ActionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
