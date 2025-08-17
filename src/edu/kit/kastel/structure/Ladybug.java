package edu.kit.kastel.structure;

import edu.kit.kastel.tree.*;

public class Ladybug {
    private Point position;
    private Direction direction;
    private int id;
    private GameManager gameManager;

    public Ladybug(Point point, Direction direction, int id) {
        this.position = point;
        this.direction = direction;
        this.id = id;
        this.gameManager = GameManager.getInstance();
    }

    public int getId() {
        return id;
    }

    public Point getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Point getFrontField() {
        return Point.scaleVektor(position, direction.getVektor());
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isLeafFront() {
        return gameManager.isLeaf(getFrontField());
    }

    public boolean isTreeFront() {
        return gameManager.isTree(getFrontField());
    }

    public boolean isMushroomFront() {
        return gameManager.isMushroom(getFrontField());
    }

    public boolean isAtEdge() {
        return gameManager.isAtEdge(position);
    }

    public boolean turnLeft() {
        direction = Direction.getDirection((direction.getIndex() + 1) % Direction.values().length);
        return true;
    }

    public boolean turnRight() {
        direction = Direction.getDirection((direction.getIndex() - 1) % Direction.values().length);
        return true;
    }

    public boolean placeLeaf() {
        return gameManager.placeLeaf(getFrontField());
    }

    public boolean takeLeaf() {
        return gameManager.takeLeaf(getFrontField());
    }

    public boolean move() {
        Point newPosition = gameManager.move(this);
        if (newPosition == null) {
            return false;
        } else {
            position = newPosition;
            return true;
        }
    }

    public boolean fly(int newX, int newY) {
        return gameManager.fly(this, new Point(newX, newY));
    }
}
