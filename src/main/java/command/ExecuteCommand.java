package command;

import parser.Parser;

public class ExecuteCommand {
    public static void executeCommand(Parser parser) {
        Command commandToBeExecuted;
        switch (parser.getCommandType()) {
        case ADDCHEATSHEET:
            commandToBeExecuted = new AddCheatSheet(parser);
            break;
        case CLEARCHEETSHEET:
            commandToBeExecuted = new ClearCheetSheet(parser);
            break;
        case DELETECHEATSHEET:
            commandToBeExecuted = new DeleteCheatSheet(parser);
            break;
        case EXIT:
            commandToBeExecuted = new Exit(parser);
            break;
        case FINDCHEATSHEET:
            commandToBeExecuted = new FindCheatSheet(parser);
            break;
        case HELP:
            commandToBeExecuted = new Help(parser);
            break;
        case LISTCHEATSHEET:
            commandToBeExecuted = new ListCheatSheets(parser);
            break;
        case VIEWCHEATSHEET:
            commandToBeExecuted = new ViewCheatSheet(parser);
            break;
        default:
            commandToBeExecuted = new Exit(parser);
        }
        commandToBeExecuted.execute();
    }
}
