package command;

import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.Parser;
import sort.SortByLanguage;
import sort.SortByName;
import storage.DataFileDestroyer;
import ui.Printer;

import java.util.Scanner;

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
