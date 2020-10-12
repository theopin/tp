package parser;

import command.CommandEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final CommandEnum commandType;
    private EnumSet<ArgumentFlagEnum> argEnumSet;
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
                return CommandEnum.ADDCHEATSHEET;
            case "/clear":
                return CommandEnum.CLEARCHEETSHEET;
            case "/delete":
                return CommandEnum.DELETECHEATSHEET;
            case "/exit":
                return CommandEnum.EXIT;
            case "/find":
                return CommandEnum.FINDCHEATSHEET;
            case "/help":
                return CommandEnum.HELP;
            case "/list":
                return CommandEnum.LISTCHEATSHEET;
            case "/view":
                return CommandEnum.VIEWCHEATSHEET;
            default:
                return CommandEnum.EXIT;
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            return CommandEnum.EXIT;
        }
    }

    private EnumSet<ArgumentFlagEnum> parseTypeOfArgument(String userInput) {
        argEnumSet = null;
        String[] parsedInput = userInput.split(" ");
        for (int i = 1; i < parsedInput.length; i++) {
            switch (parsedInput[i]) {
            case "/d":
                assert false;
                argEnumSet.add(ArgumentFlagEnum.DESCRIPTION);
                break;
            case "/n":
                assert false;
                argEnumSet.add(ArgumentFlagEnum.NAME);
                break;
            case "/i":
                assert false;
                argEnumSet.add(ArgumentFlagEnum.INDEX);
                break;
            case "/l":
                assert false;
                argEnumSet.add(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
                break;
            case "/k":
                assert false;
                argEnumSet.add(ArgumentFlagEnum.SECTIONKEYWORD);
                break;
            default:
                argEnumSet.add(ArgumentFlagEnum.DESCRIPTION);
            }
        }
        return argEnumSet;
    }

    private HashMap<ArgumentFlagEnum, String> parseDescription(String userInput) {
        descriptionMap = new HashMap<>();
        try {
            assert argEnumSet != null;
            for (ArgumentFlagEnum ae : argEnumSet) {
                Pattern pattern = Pattern.compile(ae.getAssociatedKeyWord() + ".*(?= /[idn])");
                Matcher matcher = pattern.matcher(userInput);
                String description = matcher.group();
                descriptionMap.put(ae, description);
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            return new HashMap<>();
        }
        return descriptionMap;
    }

    public CommandEnum getCommandType() {
        return commandType;
    }

    public EnumSet<ArgumentFlagEnum> getArgEnumSet() {
        return argEnumSet;
    }

    public HashMap<ArgumentFlagEnum, String> getDescriptionMap() {
        return descriptionMap;
    }

}
