package edu.kit.kastel.command;

import edu.kit.kastel.structure.*;

public class PrintPositionCommand implements Command {

    private static final String COMMAND_NAME = "print position";

    @Override
    public CommandFeedBack execute(String[] args) {
        try {
            return new CommandFeedBack(GameManager.getInstance().printPosition(Integer.parseInt(args[0])), CommandFeedBackType.SUCCESS);
        } catch (InvalidCommandException e) {
            return new CommandFeedBack("Error, " + e.getMessage(), CommandFeedBackType.FAILURE);
        } catch (NumberFormatException e) {
            return new CommandFeedBack("Error, ", CommandFeedBackType.FAILURE);
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
