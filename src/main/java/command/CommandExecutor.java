package command;

import parser.Parser;

public class CommandExecutor {
    public CommandExecutor(){
    }

    public static void execute(Parser parser/*, DataFileReader fileReader, DataFileWriter fileWriter*/) {
        Command commandToBeExecuted;
        switch (parser.getCommandType()) {
        case ADD:
            commandToBeExecuted = new AddCommand(parser);
            break;
        case CLEAR:
            commandToBeExecuted = new ClearCommand(parser);
            break;
        case DELETE:
            commandToBeExecuted = new DeleteCheatSheet(parser);
            break;
        case EXIT:
            commandToBeExecuted = new ExitCommand(parser);
            break;
        case FIND:
            commandToBeExecuted = new FindCommand(parser);
            break;
        case HELP:
            commandToBeExecuted = new Help(parser);
            break;
        case LIST:
            commandToBeExecuted = new ListCommand(parser);
            break;
        case VIEW:
            commandToBeExecuted = new ViewCommand(parser);
            break;
        default:
            commandToBeExecuted = new ExitCommand(parser);
        }
        commandToBeExecuted.execute();
    }
}
