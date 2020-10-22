package command;

import parser.Parser;
import ui.Printer;

public class ListCommand extends Command {
    public ListCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        Printer.printCheatSheetList();
    }
}
