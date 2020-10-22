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
import command.SettingsCommand;
import command.CommandEnum;

import exception.CommandException;
import storage.DataFileDestroyer;
import ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private DataFileDestroyer fileDestroyer;
    private Printer printer;
    private static final String FLAG_REGEX = " /[dnilk] ";

    public Parser() {
    }

    public Parser(DataFileDestroyer fileDestroyer, Printer printer) {
        this.fileDestroyer = fileDestroyer;
        this.printer = printer;
    }

    public Command parse(String userInput) throws CommandException {
        CommandEnum commandType = parseTypeOfCommand(userInput);
        ArrayList<ArgumentFlagEnum> argEnumSet = parseTypeOfArgument(userInput);
        HashMap<ArgumentFlagEnum, String> descriptionMap = parseDescription(userInput, argEnumSet);

        Command commandToBeExecuted = null;
        switch (commandType) {
        case ADD:
            commandToBeExecuted = new AddCommand(descriptionMap, printer);
            break;
        case CLEAR:
            commandToBeExecuted = new ClearCommand(descriptionMap, printer, fileDestroyer);
            break;
        case DELETE:
            commandToBeExecuted = new DeleteCommand(descriptionMap, printer, fileDestroyer);
            break;
        case EXIT:
            commandToBeExecuted = new ExitCommand(descriptionMap, printer);
            break;
        case FIND:
            commandToBeExecuted = new FindCommand(descriptionMap, printer);
            break;
        case HELP:
            commandToBeExecuted = new HelpCommand(descriptionMap, printer);
            break;
        case LIST:
            commandToBeExecuted = new ListCommand(descriptionMap, printer);
            break;
        case VIEW:
            commandToBeExecuted = new ViewCommand(descriptionMap, printer);
            break;
        case FAVOURITE:
            commandToBeExecuted = new FavouriteCommand(descriptionMap, printer);
            break;
        case SETTINGS:
            commandToBeExecuted = new SettingsCommand(descriptionMap, printer);
            break;
        default:
            assert false;
        }

        return commandToBeExecuted;
    }

    private CommandEnum parseTypeOfCommand(String userInput) throws CommandException {
        String parsedInput = userInput.split(" ")[0];
        switch (parsedInput) {
        case "/add":
            return CommandEnum.ADD;
        case "/clear":
            return CommandEnum.CLEAR;
        case "/delete":
            return CommandEnum.DELETE;
        case "/exit":
            return CommandEnum.EXIT;
        case "/find":
            return CommandEnum.FIND;
        case "/help":
            return CommandEnum.HELP;
        case "/list":
            return CommandEnum.LIST;
        case "/view":
            return CommandEnum.VIEW;
        case "/favourite":
            return CommandEnum.FAVOURITE;
        case "/settings":
            return CommandEnum.SETTINGS;
        default:
            throw new CommandException("Please enter a valid command");
        }
    }

    private ArrayList<ArgumentFlagEnum> parseTypeOfArgument(String userInput) {
        ArrayList<ArgumentFlagEnum> argEnumList = new ArrayList<>();

        Pattern pattern = Pattern.compile(FLAG_REGEX);
        Matcher matcher = pattern.matcher(userInput);
        ArrayList<String> argList = addMatchesToArgEnumSet(matcher);
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

    private ArrayList<String> addMatchesToArgEnumSet(Matcher matcher) {
        ArrayList<String> argList = new ArrayList<>();
        while (matcher.find()) {
            argList.add(matcher.group().trim());
        }
        return argList;
    }
}
