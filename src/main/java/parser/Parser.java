package parser;

import command.Command;
import command.AddCommand;
import command.ClearCommand;
import command.DeleteCommand;
import command.ExitCommand;
import command.ListCommand;
import command.FindCommand;
import command.HelpCommand;
import command.ViewCommand;
import command.FavouriteCommand;

import exception.CommandException;
import storage.DataFileDestroyer;
import ui.Ui;
import ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private DataFileDestroyer fileDestroyer;
    private Printer printer;
    private Ui ui;
    private static final String FLAG_REGEX = " /[a-z] ";

    public Parser() {
    }

    public Parser(DataFileDestroyer fileDestroyer, Printer printer, Ui ui) {
        this.fileDestroyer = fileDestroyer;
        this.printer = printer;
        this.ui = ui;
    }

    public Command parse(String userInput) throws CommandException {
        Command commandToBeExecuted = parseTypeOfCommand(userInput);
        ArrayList<ArgumentFlagEnum> argEnumSet = parseTypeOfArgument(userInput);
        HashMap<ArgumentFlagEnum, String> descriptionMap = parseDescription(userInput, argEnumSet);
        commandToBeExecuted.setDescriptionMap(descriptionMap);

        setMissingArguments(commandToBeExecuted);

        return commandToBeExecuted;
    }

    private Command parseTypeOfCommand(String userInput) throws CommandException {
        String parsedInput = userInput.split(" ")[0];
        switch (parsedInput) {
        case "/add":
            return new AddCommand(printer);
        case "/clear":
            return new ClearCommand(printer, fileDestroyer);
        case "/delete":
            return new DeleteCommand(printer, fileDestroyer);
        case "/exit":
            return new ExitCommand(printer);
        case "/find":
            return new FindCommand(printer);
        case "/help":
            return new HelpCommand(printer);
        case "/list":
            return new ListCommand(printer);
        case "/view":
            return new ViewCommand(printer);
        case "/favourite":
            return new FavouriteCommand(printer);
        default:
            throw new CommandException("Please enter a valid command");
        }
    }

    private ArrayList<ArgumentFlagEnum> parseTypeOfArgument(String userInput) {
        ArrayList<ArgumentFlagEnum> argEnumList = new ArrayList<>();

        Pattern flagPattern = Pattern.compile(FLAG_REGEX);
        Matcher flagMatcher = flagPattern.matcher(userInput);
        ArrayList<String> argList = addMatchesToArgEnumSet(flagMatcher);
        for (String arg : argList) {
            for (ArgumentFlagEnum ae : ArgumentFlagEnum.values()) {
                if (arg.equals(ae.getAssociatedKeyWord())) {
                    argEnumList.add(ae);
                    break;
                }
            }
        }
        return argEnumList;
    }

    private HashMap<ArgumentFlagEnum, String> parseDescription(String userInput, ArrayList<ArgumentFlagEnum> argEnumSet)
            throws CommandException {
        HashMap<ArgumentFlagEnum, String> descriptionMap = new HashMap<>();
        try {
            String[] details = userInput.split(FLAG_REGEX);
            for (int i = 1; i < details.length; i++) {
                descriptionMap.put(argEnumSet.get(i - 1), details[i].trim());
            }
        } catch (IndexOutOfBoundsException i) {
            throw new CommandException("Please enter a valid index");
        }
        return descriptionMap;
    }

    private void setMissingArguments(Command commandToBeExecuted) {
        while (!commandToBeExecuted.hasAllRequiredArguments()) {
            for (Map.Entry<ArgumentFlagEnum, String> entry : commandToBeExecuted.getDescriptionMap().entrySet()) {
                ArgumentFlagEnum curArg = entry.getKey();
                String curArgVal = entry.getValue();

                if (curArgVal == null) {
                    printer.printMissingArgument(curArg);
                    String newArgVal = ui.getUserInput();
                    commandToBeExecuted.getDescriptionMap().replace(curArg, newArgVal);
                    return;
                }
            }
        }
    }

    private ArrayList<String> addMatchesToArgEnumSet(Matcher flagMatcher) {
        ArrayList<String> argList = new ArrayList<>();

        while (flagMatcher.find()) {
            argList.add(flagMatcher.group().trim());
        }
        return argList;
    }
}
