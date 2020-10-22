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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private DataFileDestroyer fileDestroyer;
    private static final String FLAG_REGEX = " /[dnilk] ";

    public Parser(){
    }

    public Parser(DataFileDestroyer fileDestroyer) {
        this.fileDestroyer = fileDestroyer;
    }

    public Command parse(String userInput) throws CommandException {
        CommandEnum commandType = parseTypeOfCommand(userInput);
        ArrayList<ArgumentFlagEnum> argEnumSet = parseTypeOfArgument(userInput);
        HashMap<ArgumentFlagEnum, String> descriptionMap = parseDescription(userInput, argEnumSet);

        Command commandToBeExecuted = null;
        switch (commandType) {
        case ADD:
            commandToBeExecuted = new AddCommand(argEnumSet, descriptionMap);
            break;
        case CLEAR:
            commandToBeExecuted = new ClearCommand(argEnumSet, descriptionMap, fileDestroyer);
            break;
        case DELETE:
            commandToBeExecuted = new DeleteCommand(argEnumSet, descriptionMap, fileDestroyer);
            break;
        case EXIT:
            commandToBeExecuted = new ExitCommand(argEnumSet, descriptionMap);
            break;
        case FIND:
            commandToBeExecuted = new FindCommand(argEnumSet, descriptionMap);
            break;
        case HELP:
            commandToBeExecuted = new HelpCommand(argEnumSet, descriptionMap);
            break;
        case LIST:
            commandToBeExecuted = new ListCommand(argEnumSet, descriptionMap);
            break;
        case VIEW:
            commandToBeExecuted = new ViewCommand(argEnumSet, descriptionMap);
            break;
        case FAVOURITE:
            commandToBeExecuted = new FavouriteCommand(argEnumSet, descriptionMap);
            break;
        case SETTINGS:
            commandToBeExecuted = new SettingsCommand(argEnumSet, descriptionMap);
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
