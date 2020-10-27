package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.CommandFlag;
import storage.DataFileDestroyer;
import ui.Printer;

import javax.naming.Name;

public class DeleteCommand extends FinderCommand {
    protected DataFileDestroyer fileDestroyer;
    public static final String invoker = "/delete";

    public DeleteCommand(Printer printer, CheatSheetList cheatSheetList, DataFileDestroyer fileDestroyer) {
        super(printer, cheatSheetList);
        this.fileDestroyer = fileDestroyer;

        flagsToDescriptions.put(CommandFlag.NAME, null);
        flagsToDescriptions.put(CommandFlag.INDEX, null);
        alternativeArguments.add(CommandFlag.NAME);
        alternativeArguments.add(CommandFlag.INDEX);
    }

    @Override
    public void execute() throws CommandException {
        try {
            CheatSheet cheatSheetToDelete = getCheatSheetFromNameOrIndex();
            fileDestroyer.executeFunction(cheatSheetToDelete.getName());
            cheatSheetList.remove(cheatSheetToDelete.getName());
            printer.printDeleteCheatSheetMessage(cheatSheetToDelete, cheatSheetList);
        } catch (NullPointerException | IndexOutOfBoundsException | NumberFormatException e) {
            throw new CommandException("Please enter a valid name or/and index");
        }
    }
}
