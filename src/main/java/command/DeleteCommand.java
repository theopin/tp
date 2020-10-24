package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import storage.DataFileDestroyer;
import ui.Printer;

public class DeleteCommand extends FinderCommand {
    protected DataFileDestroyer fileDestroyer;

    public DeleteCommand(Printer printer, DataFileDestroyer fileDestroyer) {
        super(printer);
        this.fileDestroyer = fileDestroyer;

        initCommandDetails(new ArgumentFlagEnum[] {
            ArgumentFlagEnum.NAME,
            ArgumentFlagEnum.INDEX,
        });
    }

    @Override
    public boolean hasAllRequiredArguments() {
        if (descriptionMap.get(ArgumentFlagEnum.NAME) != null
            || descriptionMap.get(ArgumentFlagEnum.INDEX) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void execute() throws CommandException {
        try {
            CheatSheet cheatSheetToBeDeleted = getCheatSheetFromNameOrIndex();

            CheatSheetList.remove(cheatSheetToBeDeleted.getCheatSheetName());
            fileDestroyer.executeFunction(cheatSheetToBeDeleted.getCheatSheetName());
            printer.printDeleteCheatSheetMessage(cheatSheetToBeDeleted);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new CommandException("Please enter a valid name or index");
        } catch (NumberFormatException n) {
            throw new CommandException("Please enter a valid index");
        }
    }
}
