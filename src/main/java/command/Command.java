package command;

import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

import java.util.HashMap;

/**
 * The base class for all Commands.
 */
public abstract class Command {
    protected ArgumentFlagEnum[] flags;
    protected HashMap<ArgumentFlagEnum, String> descriptionMap;
    protected Printer printer;
    public static boolean isExitCommand;

    public Command() {
    }

    public Command(Printer printer) {
        this.descriptionMap = new HashMap<>();
        this.flags = new ArgumentFlagEnum[] {};
        this.printer = printer;
        isExitCommand = false;
    }

    public void initCommandDetails(ArgumentFlagEnum[] initFlags) {
        assert flags != null;
        assert descriptionMap != null;

        setFlags(initFlags);
        if (flags != null) {
            for (ArgumentFlagEnum flag : flags) {
                descriptionMap.put(flag, null);
            }
        }
    }

    protected void setFlags(ArgumentFlagEnum[] flags) {
        this.flags = flags;
    }

    public HashMap<ArgumentFlagEnum, String> getDescriptionMap() {
        return descriptionMap;
    }

    public void setDescriptionMap(HashMap<ArgumentFlagEnum, String> descriptionMap) {
        this.descriptionMap.putAll(descriptionMap);
    }

    public abstract boolean hasAllRequiredArguments();

    public abstract void execute() throws CommandException;
}
