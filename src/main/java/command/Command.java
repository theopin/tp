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
    //protected ArgumentFlagEnum[] flags;
    protected ArrayList<ArgumentFlagEnum> requiredArguments;
    protected LinkedHashMap<ArgumentFlagEnum, String> descriptionMap;
    protected Printer printer;
    public static boolean isExitCommand;

    public Command() {
    }

    public Command(Printer printer) {
        this.descriptionMap = new LinkedHashMap<>();
        this.requiredArguments = new ArrayList<>();
        //this.flags = new ArgumentFlagEnum[] {};
        this.printer = printer;
        isExitCommand = false;
    }

    /*public void initCommandDetails(ArgumentFlagEnum[] initFlags) {
        assert flags != null;
        assert descriptionMap != null;

        setFlags(initFlags);
        if (flags != null) {
            for (ArgumentFlagEnum flag : flags) {
                descriptionMap.put(flag, null);
            }
        }
    }*/

    /*protected void setFlags(ArgumentFlagEnum[] flags) {
        this.flags = flags;
    }*/

    public LinkedHashMap<ArgumentFlagEnum, String> getDescriptionMap() {
        return descriptionMap;
    }

    public void setDescriptionMap(HashMap<ArgumentFlagEnum, String> descriptionMap) {
        this.descriptionMap.putAll(descriptionMap);
    }

    public ArrayList<ArgumentFlagEnum> getRequiredArguments() {
        return requiredArguments;
    }

    public boolean hasAllRequiredArguments() {
        for (ArgumentFlagEnum arg : requiredArguments) {
            if (descriptionMap.get(arg) != null && !descriptionMap.get(arg).isEmpty()) {
                return true;
            }
        }
        return requiredArguments.size() == 0;
    }

    public abstract void execute() throws CommandException;
}
