package edu.kit.kastel.tree;

import edu.kit.kastel.structure.*;

public enum Direction {
    UP(0, '^', new Point(0, 1)),
    LEFT(1, '<', new Point(-1, 0)),
    DOWN(2, 'v', new Point(0, -1)),
    RIGHT(3, '>', new Point(1, 0));


    private int index;
    private char direction;
    private Point vektor;

    Direction(int index, char direction, Point vektor) {
        this.direction = direction;
        this.vektor = vektor;
    }

    public int getIndex() {
        return index;
    }

    public char getSymbol() {
        return direction;
    }

    public Point getVektor() {
        return vektor;
    }

    // Todo nicht schön
    public static Direction getDirection(int index) {
        for (Direction d : Direction.values()) {
            if (d.getIndex() == index) {
                return d;
            }
        }
        return null;
    }
    

}
