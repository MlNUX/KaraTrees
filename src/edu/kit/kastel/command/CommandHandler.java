package edu.kit.kastel.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CommandHandler {

    private static final String COMMAND_SEPARATOR_REGEX = " +";
    private static final String ERROR_PREFIX = "Error, ";
    private static final String COMMAND_NOT_FOUND_FORMAT = "command '%s' not found!";
    private static final String WRONG_ARGUMENTS_COUNT_FORMAT = "wrong number of arguments for command %s!";
    private static final String INVALID_RESULT_TYPE_FORMAT = "Unexpected value: %s";

    private final Map<String, Command> commands;
    private boolean running = false;

    public CommandHandler() {
        this.commands = new HashMap<>();
        this.initCommands();
    }

    public void handleUserInput() {
        this.running = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (running && scanner.hasNextLine()) {
                executeCommand(scanner.nextLine());
            }
        }
    }

    public void quit() {
        this.running = false;
    }

    private void executeCommand(String commandWithArguments) {
        if (commands.keySet().stream().anyMatch(commandWithArguments::startsWith)) {
            Command command = commands.get(commands.keySet().stream()
                    .filter(commandWithArguments::startsWith)
                    .findFirst()
                    .get()
            );
            String[] commandArguments = {};
            int commandLength = command.toString().length();
            if (commandWithArguments.length() > commandLength) {
                commandArguments = commandWithArguments
                        .substring(commandLength + 1)
                        .split(COMMAND_SEPARATOR_REGEX);
            }
            executeCommand(command, commandArguments);
        } else {
            System.err.println(ERROR_PREFIX + COMMAND_NOT_FOUND_FORMAT.formatted(commandWithArguments));
        }
    }

    private void executeCommand(Command command, String[] commandArguments) {
        if (command.getNumberOfArguments() != -1 && command.getNumberOfArguments() != commandArguments.length) {
            System.err.println(ERROR_PREFIX + WRONG_ARGUMENTS_COUNT_FORMAT.formatted(command.toString()));
        } else {
            CommandFeedBack result = command.execute(commandArguments);
            String output = switch (result.getType()) {
                case SUCCESS -> result.getMessage();
                case FAILURE -> ERROR_PREFIX + result.getMessage();
            };
            if (output != null) {
                switch (result.getType()) {
                    case SUCCESS -> System.out.println(output);
                    case FAILURE -> System.err.println(output);
                    default -> throw new IllegalStateException(INVALID_RESULT_TYPE_FORMAT.formatted(result.getType()));
                }
            }
        }
    }


    private void initCommands() {
        this.addCommand(LoadBoardCommand.getCommandName(), new LoadBoardCommand());
        this.addCommand(LoadTreesCommand.getCommandName(), new LoadTreesCommand());
        this.addCommand(ListLadyBugsCommand.getCommandName(), new ListLadyBugsCommand());
        this.addCommand(PrintPositionCommand.getCommandName(), new PrintPositionCommand());
        this.addCommand(ResetTreeCommand.getCommandName(), new ResetTreeCommand());
        this.addCommand(JumpToCommand.getCommandName(), new JumpToCommand());
        this.addCommand(QuitCommand.getCommandName(), new QuitCommand(this));
    }

    private void addCommand(String commandName, Command command) {
        this.commands.put(commandName, command);
    }

}
