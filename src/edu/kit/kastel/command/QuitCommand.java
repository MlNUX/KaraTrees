package edu.kit.kastel.command;

public class QuitCommand implements Command {

    private static final String COMMAND_NAME = "quit";
    private final CommandHandler commandHandler;

    public QuitCommand(CommandHandler handler) {
        this.commandHandler = handler;
    }

    @Override
    public CommandFeedBack execute(String[] args) {
        commandHandler.quit();
        return new CommandFeedBack("", CommandFeedBackType.SUCCESS);
    }

    @Override
    public int getNumberOfArguments() {
        return 0;
    }

    @Override
    public String toString() {
        return COMMAND_NAME;
    }

    public static String getCommandName() {
        return COMMAND_NAME;
    }
}
