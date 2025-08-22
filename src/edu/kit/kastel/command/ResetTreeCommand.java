package edu.kit.kastel.command;

import edu.kit.kastel.structure.*;

public class ResetTreeCommand implements Command {

    private static final String COMMAND_NAME = "reset tree";

    @Override
    public CommandFeedBack execute(String[] args) {
        try {
            GameManager.getInstance().resetLadybug(Integer.parseInt(args[0]));
            return new CommandFeedBack("", CommandFeedBackType.SUCCESS);
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
