package command;

import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

import java.util.HashMap;

/**
 * The base class for all Commands.
 */
public abstract class Command {
    protected HashMap<ArgumentFlagEnum, String> descriptionMap;
    protected Printer printer;
    public static boolean isExitCommand;

    public Command() {
    }

    public Command(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer) {
        this.descriptionMap = descriptionMap;
        this.printer = printer;
        isExitCommand = false;
    }

    public HashMap<ArgumentFlagEnum, String> getDescriptionMap() {
        return descriptionMap;
    }

    public abstract void execute() throws CommandException;
}
