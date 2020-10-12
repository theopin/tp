package parser;

import command.CommandEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final CommandEnum commandType;
    private final ArrayList<ArgumentFlagEnum> argEnumSet;
    private HashMap<ArgumentFlagEnum, String> descriptionMap;


    public Parser(String userInput) {
        commandType = parseTypeOfCommand(userInput);
        argEnumSet = parseTypeOfArgument(userInput);
        descriptionMap = parseDescription(userInput);
    }

    private CommandEnum parseTypeOfCommand(String userInput) {
        try {
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
                return CommandEnum.EXIT;
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            return CommandEnum.EXIT;
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

    private HashMap<ArgumentFlagEnum, String> parseDescription(String userInput) {
        descriptionMap = new HashMap<>();
        String[] details = userInput.split(" /[ndilk ]");
        for (int i = 1; i < details.length; i++) {
            descriptionMap.put(argEnumSet.get(i - 1), details[i].trim());
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
