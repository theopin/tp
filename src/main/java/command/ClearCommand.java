package command;

import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import storage.DataFileDestroyer;
import ui.Printer;

import java.util.HashMap;

public class ClearCommand extends Command {
    protected DataFileDestroyer fileDestroyer;

    public ClearCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer,
                        DataFileDestroyer fileDestroyer) {
        super(descriptionMap, printer);
        this.fileDestroyer = fileDestroyer;
    }

    @Override
    public void execute() {
        printer.printClearCheatSheetMessage(CheatSheetList.getSize());
        CheatSheetList.clear();
        fileDestroyer.executeFunction();
    }
}
