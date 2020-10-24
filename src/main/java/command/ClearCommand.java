package command;

import cheatsheet.CheatSheetList;
import storage.DataFileDestroyer;
import ui.Printer;

public class ClearCommand extends Command {
    protected DataFileDestroyer fileDestroyer;

    public static final String invoker = "/clear";

    public ClearCommand(Printer printer, DataFileDestroyer fileDestroyer) {
        super(printer);
        this.fileDestroyer = fileDestroyer;
    }

    @Override
    public void execute() {
        CheatSheetList.clear();
        fileDestroyer.executeFunction();
        printer.printClearCheatSheetMessage(CheatSheetList.getSize());
    }
}
