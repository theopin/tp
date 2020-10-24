package command;

import exception.CommandException;

import parser.CommandFlag;
import ui.Printer;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The base class for all Commands.
 */
public abstract class Command {
    protected Printer printer;

    protected ArrayList<CommandFlag> alternativeArguments;
    protected LinkedHashMap<CommandFlag, String> flagToDescription;
    public static boolean isExitCommand;

    public Command() {
    }

    public Command(Printer printer) {
        this.printer = printer;
        this.alternativeArguments = new ArrayList<>();
        this.flagToDescription = new LinkedHashMap<>();
        isExitCommand = false;
    }

    public LinkedHashMap<CommandFlag, String> getFlagToDescriptionMap() {
        return flagToDescription;
    }

    public void setFlagToDescriptionMap(HashMap<CommandFlag, String> flagToDescription) {
        this.flagToDescription.putAll(flagToDescription);
    }

    public ArrayList<CommandFlag> getAlternativeArguments() {
        return alternativeArguments;
    }

    public boolean hasAlternativeArgument() {
        if (alternativeArguments.size() == 0) {
            return true;
        }

        for (CommandFlag arg : alternativeArguments) {
            if (flagToDescription.get(arg) != null && !flagToDescription.get(arg).isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public abstract void execute() throws CommandException;
}
