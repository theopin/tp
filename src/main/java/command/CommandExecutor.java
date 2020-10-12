package command;

import parser.Parser;

import storage.DataFileReader;
import storage.DataFileWriter;

public class CommandExecutor {
    public CommandExecutor(){
    }

    public static boolean execute(Parser parser, DataFileReader fileReader, DataFileWriter fileWriter) {
        Command commandToBeExecuted;
        switch (parser.getCommandType()) {
        case ADDCHEATSHEET:
            commandToBeExecuted = new AddCommand(parser);
            break;
        case CLEARCHEETSHEET:
            commandToBeExecuted = new ClearCommand(parser);
            break;
        case DELETECHEATSHEET:
            commandToBeExecuted = new DeleteCheatSheet(parser);
            break;
        case EXIT:
            commandToBeExecuted = new ExitCommand(parser);
            break;
        case FINDCHEATSHEET:
            commandToBeExecuted = new FindCommand(parser);
            break;
        case HELP:
            commandToBeExecuted = new Help(parser);
            break;
        case LISTCHEATSHEET:
            commandToBeExecuted = new ListCommand(parser);
            break;
        case VIEWCHEATSHEET:
            commandToBeExecuted = new ViewCommand(parser);
            break;
        default:
            commandToBeExecuted = new ExitCommand(parser);
        }

        commandToBeExecuted.execute();

        if (commandToBeExecuted.isExitCommand) {
            return true;
        } else {
            return false;
        }
    }
}
