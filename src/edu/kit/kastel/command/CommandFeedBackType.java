package edu.kit.kastel.command;

/**
 * This enum represnts a set of possible Feedbacks depends on the state of the action.
 * @author udgcl
 * @version Java 21
 */
public enum CommandFeedBackType {
    /**
     * In Case an action was successfully made or a condition was successfully met, then it returns {@code SUCCESS}.
     */
    SUCCESS,
    /**
     * In Case an action was not successfully made or a condition was not  met, then it returns {@code FAILURE}.
     */
    FAILURE;

}
