package command;

import parser.Parser;
import ui.Printer;

public class ListCommand extends Command {
    public ListCommand(Parser parser) {
        super(parser);
    }

    // todo: need to ask adhy whether he can attach index to cheatsheet

    @Override
    public void execute() {
        Printer.printCheatSheetList();
    }
}
