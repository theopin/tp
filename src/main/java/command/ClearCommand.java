package command;

import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import storage.DataFileDestroyer;
import ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;


public class ClearCommand extends Command {
    protected DataFileDestroyer fileDestroyer;

    public ClearCommand(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap,
                        DataFileDestroyer fileDestroyer) {
        super(argEnumSet, descriptionMap);
        this.fileDestroyer = fileDestroyer;
    }


    @Override
    public void execute() {
        Printer.printClearCheatSheetMessage(CheatSheetList.getSize());
        CheatSheetList.clear();
        fileDestroyer.executeFunction();
    }
}
