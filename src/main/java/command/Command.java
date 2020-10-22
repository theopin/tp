package command;

import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import sort.SortByLanguage;
import sort.SortByName;
import storage.DataFileDestroyer;
import ui.Printer;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The base class for all commands.
 */
public abstract class Command {
    public static boolean isExitCommand;
    protected ArrayList<ArgumentFlagEnum> argEnumSet;
    protected HashMap<ArgumentFlagEnum, String> descriptionMap;
    protected DataFileDestroyer fileDestroyer;

    public Command() {
    }

    public Command(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap) {
        this.argEnumSet = argEnumSet;
        this.descriptionMap = descriptionMap;
        isExitCommand = false;
        fileDestroyer = new DataFileDestroyer();
    }


    public ArrayList<ArgumentFlagEnum> getArgEnumSet() {
        return argEnumSet;
    }

    public HashMap<ArgumentFlagEnum, String> getDescriptionMap() {
        return descriptionMap;
    }


    public abstract void execute() throws CommandException;
}
