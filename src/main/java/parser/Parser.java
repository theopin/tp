package parser;

import command.CommandEnum;
import exception.CommandException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final CommandEnum commandType;
    private final ArrayList<ArgumentFlagEnum> argEnumSet;
    private HashMap<ArgumentFlagEnum, String> descriptionMap;


    public Parser(String userInput) throws CommandException {
        commandType = parseTypeOfCommand(userInput);
        argEnumSet = parseTypeOfArgument(userInput);
        descriptionMap = parseDescription(userInput);
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
        default:
            throw new CommandException("Please enter a valid command");
        }
    }

    private ArrayList<ArgumentFlagEnum> parseTypeOfArgument(String userInput) {
        ArrayList<ArgumentFlagEnum> argEnumList = new ArrayList<>();
        Pattern pattern = Pattern.compile(" /[dnilk] ");
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

    private HashMap<ArgumentFlagEnum, String> parseDescription(String userInput) throws CommandException {
        descriptionMap = new HashMap<>();
        try {
            String[] details = userInput.split(" /[ndilk ]");
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

    public CommandEnum getCommandType() {
        return commandType;
    }


    public ArrayList<ArgumentFlagEnum> getArgEnumSet() {
        return argEnumSet;
    }

    public HashMap<ArgumentFlagEnum, String> getDescriptionMap() {
        return descriptionMap;
    }

}
