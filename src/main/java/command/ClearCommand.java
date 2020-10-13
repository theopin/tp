package command;

import cheatsheet.CheatSheetList;
import parser.Parser;
import storage.DataFileDestroyer;
import ui.Printer;


public class ClearCommand extends Command {
    public ClearCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        Printer.printClearCheatSheetMessage(CheatSheetList.getSize());
        CheatSheetList.clear();
        fileDestroyer.executeFunction();
    }
}
