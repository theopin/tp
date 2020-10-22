//package command;
//
//import exception.CommandException;
//import parser.Parser;
//
//public class CommandExecutor {
//    public CommandExecutor() {
//    }
//
//    public static void execute(Parser parser) throws CommandException {
//        assert parser != null;
//
//        Command commandToBeExecuted;
//        switch (parser.getCommandType()) {
//        case ADD:
//            commandToBeExecuted = new AddCommand(parser);
//            break;
//        case CLEAR:
//            commandToBeExecuted = new ClearCommand(parser);
//            break;
//        case DELETE:
//            commandToBeExecuted = new DeleteCommand(parser);
//            break;
//        case EXIT:
//            commandToBeExecuted = new ExitCommand(parser);
//            break;
//        case FIND:
//            commandToBeExecuted = new FindCommand(parser);
//            break;
//        case HELP:
//            commandToBeExecuted = new HelpCommand(parser);
//            break;
//        case LIST:
//            commandToBeExecuted = new ListCommand(parser);
//            break;
//        case VIEW:
//            commandToBeExecuted = new ViewCommand(parser);
//            break;
//        case FAVORITE:
//            commandToBeExecuted = new FavoriteCommand(parser);
//            break;
//        case SETTINGS:
//            commandToBeExecuted = new SettingsCommand(parser);
//            break;
//        default:
//            assert false;
//            return;
//        }
//        commandToBeExecuted.execute();
//    }
//}
