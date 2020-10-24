package command;

import ui.Printer;

public class HelpCommand extends Command {
    public HelpCommand(Printer printer) {
        super(printer);

        initCommandDetails(null);
    }

    @Override
    public boolean hasAllRequiredArguments() {
        return true;
    }

    @Override
    public void execute() {
        printer.printHelpSheet();
    }
}
