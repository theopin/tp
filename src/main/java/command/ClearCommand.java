package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import storage.DataFileDestroyer;
import ui.Printer;

public class ClearCommand extends Command {
    protected DataFileDestroyer fileDestroyer;

    public static final String invoker = "/clear";

    public ClearCommand(Printer printer, CheatSheetList cheatSheetList, DataFileDestroyer fileDestroyer) {
        super(printer);
        this.cheatSheetList = cheatSheetList;
        this.fileDestroyer = fileDestroyer;
    }

    @Override
    public void execute() {
        fileDestroyer.executeFunction();
        printer.printClearCheatSheetMessage(cheatSheetList.getSize());
        cheatSheetList.clear();
    }
}
