package edu.kit.kastel.command;

/**
 * This is the error, in case wrong syntax was given.
 *
 * @author udgcl
 * @version Java 21
 */
public class InvalidCommandException extends Exception {

    private static final String ERROR_PREFIX = "Error: ";

    /**
     * The error will appear, if the syntax of the input was not correct.
     *
     * @param message the note that will display to the user.
     */
    public InvalidCommandException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ERROR_PREFIX + super.getMessage();
    }
}
