package command;

import parser.Parser;
import ui.Printer;

public class HelpCommand extends Command {
    public HelpCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        Printer.printHelpSheet();
    }
}
