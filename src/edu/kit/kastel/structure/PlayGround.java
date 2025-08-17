package edu.kit.kastel.structure;

import java.util.*;

public class PlayGround {

    private static PlayGround playground;

    private List<Tree> trees;
    private List<Leave> leaves;
    private List<Mushroom> mushrooms;
    private List<Ladybug> ladybugs;
    private int[][] board;

    private PlayGround() {
        trees = new LinkedList<>();
        leaves = new LinkedList<>();
        mushrooms = new LinkedList<>();
        ladybugs = new LinkedList<>();
    }

    public static PlayGround getInstance() {
        if (playground == null) {
            playground = new PlayGround();
        }
        return playground;
    }

}
