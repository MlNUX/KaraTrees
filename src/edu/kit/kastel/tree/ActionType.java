package edu.kit.kastel.tree;

import edu.kit.kastel.structure.Ladybug;

public enum ActionType implements TreeNode {

    TURNLEFT("turnLeft") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.turnLeft();
        }
    },

    TURNRIGHT("turnRight") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.turnRight();
        }
    },

    PLACELEAF("placeLeaf") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.placeLeaf();
        }
    },

    TAKELEAF("takeLeaf") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.takeLeaf();
        }
    },

    MOVE("move") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return ladybug.move();
        }
    },

    FLY("fly") {
        @Override
        public boolean perform(Ladybug ladybug) {
            return false;
        }

        @Override
        boolean perform(Ladybug ladybug, int newX, int newY) {
            return ladybug.fly(newX, newY);
        }
    };

    private String name;

    ActionType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    abstract boolean perform(Ladybug ladybug);

    boolean perform(Ladybug ladybug, int x, int y) {
        return false;
    }
}
