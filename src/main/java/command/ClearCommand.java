package command;

import cheatsheet.CheatSheetList;
import storage.DataFileDestroyer;
import ui.Printer;
import ui.Ui;

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
        printer.printClearConfirmation();
        if (isClearConfirmed()) {
            fileDestroyer.executeFunction();
            printer.printClearCheatSheetMessage(cheatSheetList.getSize());
            cheatSheetList.clear();
        }
    }

    private boolean isClearConfirmed() {
        String userAnswer = new Ui().getUserInput();
        userAnswer = userAnswer.toLowerCase();
        return userAnswer.equals("yes") || userAnswer.equals("y");
    }
}
