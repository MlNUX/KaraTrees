package edu.kit.kastel.command;

import edu.kit.kastel.structure.GameManager;

/**
 * This class is the blueprint of all teh commands.
 *
 * @author udgcl
 * @version Java 21
 */
public interface Command {
    /**
     * this abstract method will be overwritten to describe the functionalities of the specific comand.
     *
     * @param args the console user input
     */
    CommandFeedBack execute(String[] args);

    int getNumberOfArguments();
}


