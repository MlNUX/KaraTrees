package edu.kit.kastel.command;

import edu.kit.kastel.structure.*;

public class ListLadyBugsCommand implements Command {

    private static final String COMMAND_NAME = "list ladybugs";

    @Override
    public CommandFeedBack execute(String[] args) {
        return new CommandFeedBack(GameManager.getInstance().listLadyBugs(), CommandFeedBackType.SUCCESS);
    }

    @Override
    public int getNumberOfArguments() {
        return 0;
    }

    @Override
    public String toString() {
        return COMMAND_NAME;
    }

    public static String getCommandName() {
        return COMMAND_NAME;
    }
}
