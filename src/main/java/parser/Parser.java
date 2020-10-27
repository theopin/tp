package parser;

import cheatsheet.CheatSheetList;

import command.Command;
import command.AddCommand;
import command.ClearCommand;
import command.DeleteCommand;
import command.EditCommand;
import command.ExitCommand;
import command.FavouriteCommand;
import command.FindCommand;
import command.HelpCommand;
import command.ListCommand;
import command.SettingsCommand;
import command.ViewCommand;
import editor.Editor;
import exception.CommandException;
import storage.DataFileDestroyer;
import ui.Ui;
import ui.Printer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private CheatSheetList cheatSheetList;
    private DataFileDestroyer fileDestroyer;
    private Editor editor;
    private Printer printer;
    private Ui ui;

    private static final String FLAG_REGEX = " /[a-z] ";

    public Parser() {
    }

    public Parser(CheatSheetList cheatSheetList, Editor editor,
                  DataFileDestroyer fileDestroyer,  Printer printer, Ui ui) {
        this.cheatSheetList = cheatSheetList;
        this.editor = editor;
        this.fileDestroyer = fileDestroyer;
        this.printer = printer;
        this.ui = ui;
    }

    public Command parse(String userInput) throws CommandException {
        Command commandToBeExecuted = parseCommandType(userInput);
        ArrayList<CommandFlag> flags = parseFlags(userInput);
        LinkedHashMap<CommandFlag, String> flagsToDescriptions = parseFlagDescriptions(userInput, flags);

        commandToBeExecuted.setFlagstodescriptionsMap(flagsToDescriptions);
        setMissingDescriptions(commandToBeExecuted);
        return commandToBeExecuted;
    }

    private Command parseCommandType(String userInput) throws CommandException {
        String parsedInput = userInput.split(" ")[0];
        switch (parsedInput) {
        case AddCommand.invoker:
            return new AddCommand(printer, cheatSheetList, editor);
        case ClearCommand.invoker:
            return new ClearCommand(printer, cheatSheetList, fileDestroyer);
        case DeleteCommand.invoker:
            return new DeleteCommand(printer, cheatSheetList, fileDestroyer);
        case EditCommand.invoker:
            return new EditCommand(printer, cheatSheetList, editor);
        case ExitCommand.invoker:
            return new ExitCommand(printer);
        case FavouriteCommand.invoker:
            return new FavouriteCommand(printer, cheatSheetList);
        case FindCommand.invoker:
            return new FindCommand(printer, cheatSheetList);
        case HelpCommand.invoker:
            return new HelpCommand(printer);
        case ListCommand.invoker:
            return new ListCommand(printer, cheatSheetList);
        case SettingsCommand.invoker:
            return new SettingsCommand(printer);
        case ViewCommand.invoker:
            return new ViewCommand(printer, cheatSheetList);
        default:
            throw new CommandException("Please enter a valid command");
        }
    }

    private ArrayList<CommandFlag> parseFlags(String userInput) {
        ArrayList<CommandFlag> flags = new ArrayList<>();
        Pattern flagPattern = Pattern.compile(FLAG_REGEX);
        Matcher flagMatcher = flagPattern.matcher(userInput);
        ArrayList<String> matchedFlagNames = getMatches(flagMatcher);

        for (String flag : matchedFlagNames) {
            for (CommandFlag ae : CommandFlag.values()) {
                if (flag.equals(ae.getFlag())) {
                    flags.add(ae);
                    break;
                }
            }
        }

        return flags;
    }

    private LinkedHashMap<CommandFlag, String> parseFlagDescriptions(String userInput, ArrayList<CommandFlag> flags)
            throws CommandException {
        LinkedHashMap<CommandFlag, String> flagsToDescriptions = new LinkedHashMap<>();
        try {
            String[] details = userInput.split(FLAG_REGEX);
            for (int i = 1; i < details.length; i++) {
                if (details[i].contains("/")) {
                    throw new CommandException("Invalid command");
                }
                if (flags.get(i - 1).equals(CommandFlag.NAME) || flags.get(i - 1).equals(CommandFlag.SUBJECT)) {
                    details[i].replaceAll("\t", "");
                }
                flagsToDescriptions.put(flags.get(i - 1), details[i].trim());
            }
        } catch (IndexOutOfBoundsException i) {
            throw new CommandException("Please enter a valid index");
        }

        return flagsToDescriptions;
    }

    private void setMissingDescriptions(Command commandToBeExecuted) {
        LinkedHashMap<CommandFlag, String> map = commandToBeExecuted.getFlagstodescriptionsMap();
        while (!commandToBeExecuted.hasAlternativeArgument()) {
            printer.printAlternativeArgumentPrompt(commandToBeExecuted);

            for (CommandFlag key : map.keySet()) {
                if (map.get(key) == null || map.get(key).isBlank()) {
                    printer.printMissingArgument(key);
                    String newArgVal = ui.getUserInput();
                    if (newArgVal.isBlank()) {
                        newArgVal = null;
                    }
                    commandToBeExecuted.getFlagstodescriptionsMap().replace(key, newArgVal);
                }
            }
        }
    }

    private ArrayList<String> getMatches(Matcher flagMatcher) {
        ArrayList<String> argList = new ArrayList<>();

        while (flagMatcher.find()) {
            argList.add(flagMatcher.group().trim());
        }

        return argList;
    }
}
