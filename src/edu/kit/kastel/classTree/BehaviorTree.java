package edu.kit.kastel.classTree;

import edu.kit.kastel.command.InvalidCommandException;
import edu.kit.kastel.structure.Ladybug;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BehaviorTree {

    private static final String SYMBOL_NOT_FOUND_ERROR = "Symbol %s not found";

    private InnerNode root;
    private Ladybug ladybug;
    private Node current;
    private Map<String, Node> nodes;

    public BehaviorTree(Ladybug ladybug, InnerNode root) {
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

    public void jumpToNode(String symbol) throws InvalidCommandException {
        if (nodes.containsKey(symbol)) {
            current = nodes.get(symbol);
            return;
        }
        throw new InvalidCommandException(SYMBOL_NOT_FOUND_ERROR.formatted(symbol));
    }


    public String performTree(Ladybug ladybug) {
        String result = printRemaningTree();
        current.perform(ladybug);
    }

    private String printRemaningTree() {
        StringBuilder sb = new StringBuilder();
        Queue<InnerNode> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            for (Node node : queue.poll().children) {
                sb.append(printNode(ladybug, node));
                if (node.getClass() == InnerNode.class) {
                    InnerNode innerNode = (InnerNode) node;
                    queue.add(innerNode);
                }
            }
        }
        return sb.toString();
    }

    private String printNode(Ladybug ladybug, Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append(ladybug.getId()).append(" ")
                .append(node.symbol)
                .append(" ")
                .append(node.name)
                .append(" ");
        if (node.getClass() == InnerNode.class) {
            InnerNode innerNode = (InnerNode) node;
            sb.append("ENTRY").append('\n');
        } else {
            sb.append(node.perform(ladybug));
        }
        return sb.toString();
    }

}
