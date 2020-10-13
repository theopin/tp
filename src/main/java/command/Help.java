package command;

import parser.Parser;
import ui.Printer;

public class Help extends Command {
    public Help(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        Printer.printHelpSheet();
    }
}
