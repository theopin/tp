package command;

import cheatsheet.CheatSheetList;
import storage.DataFileDestroyer;
import storage.DataFileReader;
import ui.Printer;
import ui.Ui;

public class ClearCommand extends Command {
    protected DataFileDestroyer fileDestroyer;
    protected DataFileReader fileReader;

    public static final String invoker = "/clear";

    public ClearCommand(Printer printer, CheatSheetList cheatSheetList,
                        DataFileDestroyer fileDestroyer, DataFileReader fileReader) {
        super(printer);
        this.cheatSheetList = cheatSheetList;
        this.fileDestroyer = fileDestroyer;
        this.fileReader = fileReader;
    }

    @Override
    public void execute() {
        printer.printClearConfirmation();
        if (isClearConfirmed()) {
            final int deletedCheatSheets = cheatSheetList.getSize();
            fileDestroyer.executeFunction();
            cheatSheetList.clear();
            fileReader.extractPreloadedCheatSheets();
            fileReader.executeFunction();
            printer.printClearCheatSheetMessage(deletedCheatSheets);
        }
    }

    private boolean isClearConfirmed() {
        String userAnswer = new Ui().getUserInput();
        userAnswer = userAnswer.toLowerCase();
        return userAnswer.equals("yes") || userAnswer.equals("y");
    }
}
