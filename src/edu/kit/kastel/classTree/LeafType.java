package edu.kit.kastel.classTree;

import edu.kit.kastel.structure.Ladybug;

public enum LeafType {

    TURNLEFT("turnLeft", "action") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.turnLeft();
        }
    },

    TURNRIGHT("turnRight", "action") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.turnRight();
        }
    },

    PLACELEAF("placeLeaf", "action") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.placeLeaf();
        }
    },

    TAKELEAF("takeLeaf", "action") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.takeLeaf();
        }
    },

    MOVE("move", "action") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.move();
        }
    },

    FLY("fly", "action") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            if (args.length == 2) {
                return ladybug.fly(args[0], args[1]);
            }
            return false;

        }
    },
    LEAFFRONT("leafFront", "condition") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.isLeafFront();
        }
    },
    TREEFRONT("treeFront", "condition") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.isTreeFront();
        }
    },
    MUSHROOMFRONT("mushroomFront", "condition") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.isMushroomFront();
        }
    },
    ATEDGE("atEdge", "condition") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            return ladybug.isAtEdge();
        }
    },
    EXISTSPath("existsPath", "condition") {
        @Override
        public boolean perform(Ladybug ladybug, int... args) {
            if (args.length == 2) {
                return ladybug.existPath(args[0], args[1]);
            } else if (args.length == 4) {
                return ladybug.existPath(args[0], args[1], args[2], args[3]);
            } else {
                return false;
            }
        }
    };

    private final String name;
    private final String leafType;

    LeafType(String name, String leafType) {
        this.name = name;
        this.leafType = leafType;
    }

    public String getName() {
        return name;
    }

    public String getLeafType() {
        return leafType;
    }

    abstract public boolean perform(Ladybug ladybug, int... args);

}
