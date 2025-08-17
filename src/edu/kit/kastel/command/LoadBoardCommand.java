package edu.kit.kastel.command;

import edu.kit.kastel.structure.*;

public class LoadBoardCommand implements Command {

    private static final String COMMAND_NAME = "load board";

    @Override
    public CommandFeedBack execute(String[] args) {
        try {
            return new CommandFeedBack(GameManager.getInstance().loadBoard(args[0]), CommandFeedBackType.SUCCESS);
        } catch (InvalidCommandException e) {
            return new CommandFeedBack(e.getMessage(), CommandFeedBackType.FAILURE);
        }
    }

    @Override
    public int getNumberOfArguments() {
        return 1;
    }

    @Override
    public String toString() {
        return COMMAND_NAME;
    }

    public static String getCommandName() {
        return COMMAND_NAME;
    }
}
