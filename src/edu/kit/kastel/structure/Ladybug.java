package edu.kit.kastel.structure;

import edu.kit.kastel.classTree.BehaviorTree;

public class Ladybug {
    private Point position;
    private Direction direction;
    private int id;
    private GameManager gameManager;
    private BehaviorTree behaviorTree;

    public Ladybug(Point point, Direction direction, int id, BehaviorTree behaviorTree) {
        this.position = point;
        this.direction = direction;
        this.id = id;
        this.gameManager = GameManager.getInstance();
        this.behaviorTree = behaviorTree;
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

    public BehaviorTree getBehaviorTree() {
        return behaviorTree;
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

    public boolean existPath(int newX, int newY) {
        return gameManager.existPath(position.getX(), position.getY(), newX, newY);
    }

    public boolean existPath(int currentX, int currentY, int newX, int newY) {
        return gameManager.existPath(currentX, currentY, newX, newY);
    }

}
