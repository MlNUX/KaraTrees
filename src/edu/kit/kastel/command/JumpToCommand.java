package edu.kit.kastel.command;

import edu.kit.kastel.structure.*;

public class JumpToCommand implements Command {

    private static final String COMMAND_NAME = "jump to";

    @Override
    public CommandFeedBack execute(String[] args) {
        try {
            GameManager.getInstance().jumpTo(Integer.parseInt(args[0]), args[1]);
            return new CommandFeedBack("", CommandFeedBackType.SUCCESS);
        } catch (InvalidCommandException e) {
            return new CommandFeedBack(e.getMessage(), CommandFeedBackType.FAILURE);
        }
    }

    @Override
    public int getNumberOfArguments() {
        return 2;
    }

    @Override
    public String toString() {
        return COMMAND_NAME;
    }

    public static String getCommandName() {
        return COMMAND_NAME;
    }

}
