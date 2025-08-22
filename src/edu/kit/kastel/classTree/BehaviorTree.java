package edu.kit.kastel.classTree;

import edu.kit.kastel.command.InvalidCommandException;
import edu.kit.kastel.structure.Ladybug;

import java.util.HashMap;
import java.util.Map;

public class BehaviorTree {

    private static final String SYMBOL_NOT_FOUND_ERROR = "Symbol %s not found";

    private Node root;
    private Ladybug ladybug;
    private Node current;
    private Map<String, Node> nodes;

    public BehaviorTree(Ladybug ladybug, Node root) {
        this.ladybug = ladybug;
        this.root = root;
        this.current = root;
        this.nodes = new HashMap<>();
        nodes.put(root.symbol, root);
    }

    public Node getRoot() {
        return root;
    }

    public Node getCurrent() {
        return current;
    }

    public void reset() {
        current = root;
    }

    public void addSibling(String symbol, String newNode) throws InvalidCommandException {
        if (nodes.containsKey(symbol)) {
            String nodeSymbol = newNode.substring(0, newNode.indexOf('['));
            String nodeName = newNode.substring(newNode.indexOf('[') + 1, newNode.indexOf(']'));
            Node node = new Leaf(nodeSymbol, nodeName, LeafType.valueOf(nodeName));
            nodes.put(symbol, node);
            ((InnerNode) nodes.get(symbol)).addChild(node);
        }
        throw new InvalidCommandException(SYMBOL_NOT_FOUND_ERROR.formatted(symbol));
    }

    public boolean jumpToNode(String symbol) throws InvalidCommandException {
        if (nodes.containsKey(symbol)) {
            current = nodes.get(symbol);
            return true;
        }
        throw new InvalidCommandException(SYMBOL_NOT_FOUND_ERROR.formatted(symbol));
    }

}
