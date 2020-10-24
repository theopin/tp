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

        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.INDEX, null);
        alternativeArguments.add(ArgumentFlagEnum.NAME);
        alternativeArguments.add(ArgumentFlagEnum.INDEX);
    }

    @Override
    public void execute() throws CommandException {
        try {
            CheatSheet cheatSheetToDelete = getCheatSheetFromNameOrIndex();

            CheatSheetList.remove(cheatSheetToDelete.getName());
            fileDestroyer.executeFunction(cheatSheetToDelete.getName());
            printer.printDeleteCheatSheetMessage(cheatSheetToDelete);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new CommandException("Please enter a valid name or index");
        } catch (NumberFormatException n) {
            throw new CommandException("Please enter a valid index");
        }
    }
}
