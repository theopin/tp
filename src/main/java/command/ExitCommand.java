package command;

import ui.Printer;

public class ExitCommand extends Command {
    public ExitCommand(Printer printer) {
        super(printer);
    }

    @Override
    public void execute() {
        isExitCommand = true;
    }
}
