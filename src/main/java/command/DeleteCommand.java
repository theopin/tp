package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import storage.DataFileDestroyer;
import ui.Printer;

public class DeleteCommand extends Command {
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
        int index;
        String name;
        CheatSheet cheatSheetToBeDeleted = null;
        try {
            if (descriptionMap.containsKey(ArgumentFlagEnum.NAME)) {
                name = descriptionMap.get(ArgumentFlagEnum.NAME);
                cheatSheetToBeDeleted = CheatSheetList.getCheatSheet(name);
            } else if (descriptionMap.containsKey(ArgumentFlagEnum.INDEX)) {
                index = Integer.parseInt(descriptionMap.get(ArgumentFlagEnum.INDEX));
                cheatSheetToBeDeleted = CheatSheetList.getCheatSheet(index);
            }

            if (cheatSheetToBeDeleted == null) {
                throw new CommandException("Please enter a name or an index");
            }

            CheatSheetList.remove(cheatSheetToBeDeleted.getCheatSheetName());
            fileDestroyer.executeFunction(cheatSheetToBeDeleted.getCheatSheetName());
            printer.printDeleteCheatSheetMessage(cheatSheetToBeDeleted);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new CommandException("Please enter valid arguments");
        } catch (NumberFormatException n) {
            throw new CommandException("Please enter a valid index");
        }
    }
}
