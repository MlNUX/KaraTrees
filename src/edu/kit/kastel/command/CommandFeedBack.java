package edu.kit.kastel.command;

/**
 * This class is responsible for the feedback that the user get when an action was made or a condition was met.
 * @author udgcl
 * @version Java 21
 */
public class CommandFeedBack {

    private final String message;
    private final CommandFeedBackType commandType;

    /**
     * Whenever an action was made or a condition was met it returns a feedback.
     * @param message either Success or Failure .
     * @param commandType to determine the command that is executed.
     */
    public CommandFeedBack(String message, CommandFeedBackType commandType) {
        this.message = message;
        this.commandType = commandType;
    }

    /**
     * the message of the state of the action/condition.
     * @return the message of the state of the action/condition.
     */
    public String getMessage() {
        return message;
    }

    /**
     * the command type.
     * @return the command.
     */
    public CommandFeedBackType getType() {
        return commandType;
    }


}
