package edu.kit.kastel.structure;

import edu.kit.kastel.command.*;
import edu.kit.kastel.tree.Direction;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * This class manages the whole game.
 *
 * @author udgcl
 * @version Java 21
 */
public class GameManager {

    private static final String INVALID_BUG_MESSAGE = "Invalid bug number!";

    private static GameManager gameManager;
    private static final String BOARD_LAYOUT = "|%s|";
    private int width;
    private int height;

    private List<Ladybug> ladybugs;
    private Tiles[][] board;

    private GameManager() {
        ladybugs = new LinkedList<>();
    }

    public static GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public String loadBoard(String path) throws InvalidCommandException {
        List<String> lines;
        try {
            lines = Files.readAllLines(FileSystems.getDefault().getPath(path));
        } catch (IOException e) {
            throw new InvalidCommandException("Error, file not found!");
        }
        width = lines.getFirst().length();
        height = lines.size();
        board = new Tiles[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = Tiles.valueOf(String.valueOf(lines.get(i).charAt(j)));
            }
        }
        // hässlich!!!
        // Todo mach schön!!
        StringBuilder boardAsString = new StringBuilder();
        boardAsString.append("+");
        for (int i = 0; i < width; i++) {
            boardAsString.append("-");
        }
        boardAsString.append("+");
        for (int i = 0; i < height; i++) {
            boardAsString.append(BOARD_LAYOUT.formatted(lines.get(i)));
        }
        boardAsString.append("+");
        for (int i = 0; i < width; i++) {
            boardAsString.append("-");
        }
        boardAsString.append("+");

        return boardAsString.toString();
    }

    public String loadTree(String path) throws InvalidCommandException {
        //Todo das hier
        return null;
    }


    public String listLadyBugs() {
        StringBuilder result = new StringBuilder();
        ladybugs.forEach(ladybug -> {
            result.append(ladybug.getId());
            if (!ladybugs.getLast().equals(ladybug)) result.append(" ");
        });
        return result.toString();
    }

    public String printPosition(int id) throws InvalidCommandException {
        if (ladybugs.size() > id) {
            return ladybugs.get(id).getPosition().toString();
        }
        throw new InvalidCommandException(INVALID_BUG_MESSAGE);
    }

    public void resetLadybug(int id) throws InvalidCommandException {
        if (ladybugs.size() > id) {
            ladybugs.get(id).resetBehaviourTree();
            return;
        }
        throw new InvalidCommandException(INVALID_BUG_MESSAGE);
    }

    public String getCurrentNode(int id) throws InvalidCommandException {
        if (ladybugs.size() > id) {
            return ladybugs.get(id).getCurrentNode();
        }
        throw new InvalidCommandException(INVALID_BUG_MESSAGE);

    }

    public void jumpTo(int id, String node) throws InvalidCommandException {
        //Todo: shit
    }

    private boolean isValidField(Point point) {
        int x = point.getX();
        int y = point.getY();

        return x >= 0 && x < width
                && y >= 0 && y < height;
    }

    private boolean isFieldEmpty(Point point) {
        int x = point.getX();
        int y = point.getY();
        return isValidField(point) && board[y][x] == Tiles.EMPTY;
    }

    public void cleanField(int x, int y) {
        board[x][y] = Tiles.EMPTY;
    }

    public void cleanField(Point point) {
        board[point.getX()][point.getY()] = Tiles.EMPTY;
    }

    public boolean isLeaf(Point point) {
        return isValidField(point)
                && board[point.getX()][point.getY()] == Tiles.LEAF;
    }

    public boolean isTree(Point point) {
        return isValidField(point)
                && board[point.getX()][point.getY()] == Tiles.TREE;
    }

    public boolean isMushroom(Point point) {
        return isValidField(point)
                && board[point.getX()][point.getY()] == Tiles.MUSHROOM;
    }

    public boolean isAtEdge(Point point) {
        int x = point.getX();
        int y = point.getY();
        return x == 0 || x == width - 1 || y == 0 || y == height - 1;
    }

    public boolean placeLeaf(Point point) {
        if (isFieldEmpty(point)) {
            board[point.getX()][point.getY()] = Tiles.LEAF;
            return true;
        }
        return false;
    }

    public boolean takeLeaf(Point point) {
        if (isValidField(point) && board[point.getX()][point.getY()] == Tiles.LEAF) {
            board[point.getX()][point.getY()] = Tiles.EMPTY;
            return true;
        }
        return false;
    }

    public Point move(Ladybug ladybug) {
        if (!ladybugs.contains(ladybug)) {
            return null;
        }

        int currentX = ladybug.getPosition().getX();
        int currentY = ladybug.getPosition().getY();
        int newX = ladybug.getFrontField().getX();
        int newY = ladybug.getFrontField().getY();
        Point behindMushroom = Point.scaleVektor(ladybug.getDirection().getVektor(), ladybug.getFrontField());

        if (isFieldEmpty(ladybug.getFrontField())) {
            cleanField(currentX, currentY);
            board[newX][newY] = Tiles.LADYBUG;
            return new Point(newX, newY);
        } else if (isValidField(ladybug.getFrontField())
                && board[currentX][currentY] == Tiles.MUSHROOM
                && isFieldEmpty(behindMushroom)) {
            cleanField(currentX, currentY);
            board[behindMushroom.getX()][behindMushroom.getY()] = Tiles.LADYBUG;
            return behindMushroom;
        } else {
            return null;
        }
    }

    public boolean fly(Ladybug ladybug, Point point) {
        Point shiftedPoint = new Point(point.getX() - 1, point.getY() - 1);
        if (!isFieldEmpty(shiftedPoint)) {
            return false;
        }

        int horizontal = shiftedPoint.getX() - ladybug.getPosition().getX();
        int vertical = shiftedPoint.getY() - ladybug.getPosition().getY();

        cleanField(ladybug.getPosition());
        board[shiftedPoint.getX()][shiftedPoint.getY()] = Tiles.LADYBUG;
        //Todo wenn gleich ist?
        if (horizontal > vertical) {
            ladybug.setDirection(horizontal > 0 ? Direction.RIGHT : Direction.LEFT);
        } else {
            ladybug.setDirection(vertical > 0 ? Direction.DOWN : Direction.UP);
        }
        return true;

    }

}
