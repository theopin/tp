package command;

import exception.CommandException;

import parser.ArgumentFlagEnum;
import ui.Printer;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The base class for all Commands.
 */
public abstract class Command {
    protected ArrayList<ArgumentFlagEnum> alternativeArguments;
    protected LinkedHashMap<ArgumentFlagEnum, String> descriptionMap;
    protected Printer printer;
    public static boolean isExitCommand;

    public Command() {
    }

    public Command(Printer printer) {
        this.descriptionMap = new LinkedHashMap<>();
        this.alternativeArguments = new ArrayList<>();
        this.printer = printer;
        isExitCommand = false;
    }

    public LinkedHashMap<ArgumentFlagEnum, String> getDescriptionMap() {
        return descriptionMap;
    }

    public void setDescriptionMap(HashMap<ArgumentFlagEnum, String> descriptionMap) {
        this.descriptionMap.putAll(descriptionMap);
    }

    public ArrayList<ArgumentFlagEnum> getAlternativeArguments() {
        return alternativeArguments;
    }

    public boolean hasOneAlternativeArgument() {
        for (ArgumentFlagEnum arg : alternativeArguments) {
            if (descriptionMap.get(arg) != null && !descriptionMap.get(arg).isEmpty()) {
                return true;
            }
        }
        return alternativeArguments.size() == 0;
    }

    public abstract void execute() throws CommandException;
}
