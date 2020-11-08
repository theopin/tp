package command;

import cheatsheet.CheatSheetList;
import storage.DataFile;
import storage.DataFileDestroyer;
import storage.DataFileReader;
import ui.Printer;
import ui.Ui;

/**
 * Command to remove all cheatsheets from CheatSheetList.
 */
public class ClearCommand extends Command {
    protected DataFileDestroyer fileDestroyer;
    protected DataFileReader fileReader;

    public static final String invoker = "/clear";


    /**
     * Constructor for the ClearCommand.
     * No command argument is required.
     *
     * @param printer        The printer object to handle user interaction
     * @param cheatSheetList The current list of cheat sheets
     * @param fileDestroyer  The fileDestroyer object removes cheat sheet file from the /data folder
     */
    public ClearCommand(Printer printer, CheatSheetList cheatSheetList, DataFileDestroyer fileDestroyer,
                       DataFileReader fileReader) {
        super(printer);
        this.cheatSheetList = cheatSheetList;
        this.fileDestroyer = fileDestroyer;
        this.fileReader = fileReader;
    }

    /**
     * Removes all cheatsheets from CheatSheetList object.
     * Removes all cheatsheet files from /data folder.
     */
    @Override
    public void execute() {
        printer.printClearConfirmation();
        if (isClearConfirmed()) {
            final int deletedCheatSheets = cheatSheetList.getSize()
                    - DataFile.preloadedCheatSheets.size();
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
