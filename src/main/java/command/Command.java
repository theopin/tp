package command;

import exception.CommandException;
import parser.Parser;
import storage.DataFileDestroyer;

/**
 * The base class for all commands.
 */
public abstract class Command {
    public static boolean isExitCommand;
    protected Parser parser;
    protected DataFileDestroyer fileDestroyer;

    public Command(Parser parser) {
        this.parser = parser;
        isExitCommand = false;
        fileDestroyer = new DataFileDestroyer();
    }

    public abstract void execute() throws CommandException;
}
