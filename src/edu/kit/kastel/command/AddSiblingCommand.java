package edu.kit.kastel.command;

public class AddSiblingCommand implements Command {

    private static final String COMMAND_NAME = "add sibling";

    @Override
    public CommandFeedBack execute(String[] args) {
        return null;
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
