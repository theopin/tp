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
    private final ArrayList<ArgumentFlagEnum> argEnumSet;
    private HashMap<ArgumentFlagEnum, String> descriptionMap;
    protected DataFileDestroyer fileDestroyer;

    public Command() {
        this.parser = parser;
        isExitCommand = false;
        fileDestroyer = new DataFileDestroyer();
    }

    public abstract void execute() throws CommandException;
}
