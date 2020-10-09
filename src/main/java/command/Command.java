package command;

/**
 * The base class for all commands.
 */

public abstract class Command {
    public boolean isExitCommand;

    public Command() {
        isExitCommand = false;
    }

    public abstract void execute();
}
