package edu.kit.kastel.structure;

public enum Tiles {

    TREE("#"),
    LEAF("*"),
    MUSHROOM("o"),
    EMPTY("."),
    LADYBUG("^>v<");

    private String code;

    Tiles(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
