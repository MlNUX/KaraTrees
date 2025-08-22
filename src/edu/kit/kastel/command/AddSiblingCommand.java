package edu.kit.kastel.command;

import edu.kit.kastel.structure.GameManager;

public class AddSiblingCommand implements Command {

    private static final String COMMAND_NAME = "add sibling";

    @Override
    public CommandFeedBack execute(String[] args) {
        try {
            GameManager.getInstance().addSibling(Integer.parseInt(args[0]), args[1], args[2]);
            return new CommandFeedBack("", CommandFeedBackType.SUCCESS);
        } catch (InvalidCommandException e) {
            return new CommandFeedBack(e.getMessage(), CommandFeedBackType.FAILURE);
        } catch (NumberFormatException e) {
            return new CommandFeedBack(e.getMessage(), CommandFeedBackType.FAILURE);
        }
    }

    @Override
    public int getNumberOfArguments() {
        return 3;
    }

    @Override
    public String toString() {
        return COMMAND_NAME;
    }

    public static String getCommandName() {
        return COMMAND_NAME;
    }
}
