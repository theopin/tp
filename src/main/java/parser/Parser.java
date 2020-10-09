package parser;

import command.CommandEnum;

public class Parser {
    CommandEnum parser(String userInput) {
        try {
            String parsedInput = userInput.split(" ")[0];
            switch (parsedInput) {
            case "/add":
                return CommandEnum.ADDCHEATSHEET;
            case "/clear":
                return CommandEnum.CLEARCHEETSHEET;
            case "/delete":
                return CommandEnum.DELETECHEATHSHEET;
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
}
