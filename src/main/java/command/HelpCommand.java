package command;

import ui.Printer;

public class HelpCommand extends Command {
    public HelpCommand(Printer printer) {
        super(printer);
    }

    @Override
    public void execute() {
        printer.printHelpSheet();
    }
}
