package edu.kit.kastel.structure;

import edu.kit.kastel.command.InvalidCommandException;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class TreeParser {

    private static final String TO_MANY_BUGS = "to many bugs!";
    private static final String FILE_NOT_FOUND = "file not found!";
    private static final String WRONG_FILE_SYNTAX = "your file has the wrong syntax! looser";
    private static final String FILE_START = "flowchart TD";

    private final String[] possibleVars = {"->", "=>", };

    private boolean treeParser(List<String> lines) throws InvalidCommandException {

        String bugPosition = null;
        if (!lines.getFirst().equals(FILE_START)) {
            throw new InvalidCommandException(WRONG_FILE_SYNTAX);
        }
        lines = lines.subList(1, lines.size() - 1);
        String variab = "";
        String bugPositionRegex = "([A-Z])\\s-->\\s([A-Z])(\\(\\[" + variab + "\\]\\)|\\[" + variab + "\\])";
        for (String line : lines) {
            for()
        }
    }


    // fertig machen
    public String loadTree(String[] paths) throws InvalidCommandException {
        if (paths.length > 4) throw new InvalidCommandException(TO_MANY_BUGS);

        for (String path : paths) {
            List<String> lines;
            try {
                lines = Files.readAllLines(FileSystems.getDefault().getPath(path));
            } catch (IOException e) {
                throw new InvalidCommandException(FILE_NOT_FOUND);
            }

        }

        String pattern = "%s%s --> %s %s";
        for (String line : lines) {

        }
        if (numberOfTrees > ladybugs.size()) {

        }
        return null;
    }

}
