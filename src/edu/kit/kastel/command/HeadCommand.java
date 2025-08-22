package edu.kit.kastel.command;

import edu.kit.kastel.structure.GameManager;

public class HeadCommand implements Command {

    private static final String COMMAND_NAME = "head";

    @Override
    public CommandFeedBack execute(String[] args) {
        try {
            return new CommandFeedBack(GameManager.getInstance().getCurrentBugNode(Integer.parseInt(args[0])), CommandFeedBackType.SUCCESS);
        } catch (InvalidCommandException e) {
            return new CommandFeedBack(e.getMessage(), CommandFeedBackType.FAILURE);
        } catch (NumberFormatException e) {
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
