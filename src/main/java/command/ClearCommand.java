package command;

import cheatsheet.CheatSheetList;
import parser.Parser;
import ui.Printer;


public class ClearCommand extends Command {
    public ClearCommand(Parser parser) {
        super(parser);
    }
    // todo: ask adhy whether he can add one more function to delete all cheatsheets

    @Override
    public void execute() {
        Printer.printClearCheatSheetMessage(CheatSheetList.getSize());
        CheatSheetList.clear();
    }
}
