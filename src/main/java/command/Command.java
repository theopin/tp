package command;

import exception.CommandException;
import parser.Parser;

/**
 * The base class for all commands.
 */
public abstract class Command {
    public static boolean isExitCommand;
    protected Parser parser;

    public Command(Parser parser) {
        this.parser = parser;
        isExitCommand = false;
    }

    public abstract void execute() throws CommandException;
}
