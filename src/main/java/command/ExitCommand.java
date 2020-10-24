package command;

import ui.Printer;

public class ExitCommand extends Command {
    public ExitCommand(Printer printer) {
        super(printer);

        //initCommandDetails(null);
    }
    /*
    @Override
    public boolean hasAllRequiredArguments() {
        return true;
    }
    */

    @Override
    public void execute() {
        isExitCommand = true;
    }
}
