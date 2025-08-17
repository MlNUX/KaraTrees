package edu.kit.kastel.command;

public class HeadCommand implements Command {

    private static final String COMMAND_NAME = "head";

    @Override
    public CommandFeedBack execute(String[] args) {
        return null;
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
