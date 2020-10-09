package command;

/**
 * The base class for all commands.
 */

public abstract class Command {
    public boolean isExitCommand;

    public Command() {
        isExitCommand = false;
    }

    public abstract void execute();

    public void execute(CommandEnum commandType) {
        Command commandToBeExecuted;
        switch (commandType) {
        case ADDCHEATSHEET:
            commandToBeExecuted = new AddCheatSheet();
            break;
        case CLEARCHEETSHEET:
            commandToBeExecuted = new ClearCheetSheet();
            break;
        case DELETECHEATHSHEET:
            commandToBeExecuted = new DeleteCheatSheet();
            break;
        case EXIT:
            commandToBeExecuted = new Exit();
            break;
        case FINDCHEATSHEET:
            commandToBeExecuted = new FindCheatSheet();
            break;
        case HELP:
            commandToBeExecuted = new Help();
            break;
        case LISTCHEATSHEET:
            commandToBeExecuted = new ListCheatSheets();
            break;
        case VIEWCHEATSHEET:
            commandToBeExecuted = new ViewCheatSheet();
            break;
        default:
            commandToBeExecuted = new Exit();
        }
        commandToBeExecuted.execute();
    }

}
