package edu.kit.kastel.classTree;

import java.util.LinkedList;
import java.util.List;

abstract class InnerNode extends Node {

    List<Node> children;

    InnerNode(String name, String symbol) {
        super(name, symbol);
        children = new LinkedList<>();
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node node) {
        children.add(node);

    }
}
