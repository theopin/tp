package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import storage.DataFileDestroyer;
import ui.Printer;

import java.util.HashMap;


public class DeleteCommand extends Command {
    protected DataFileDestroyer fileDestroyer;

    public DeleteCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer,
                         DataFileDestroyer fileDestroyer) {
        super(descriptionMap, printer);
        this.fileDestroyer = fileDestroyer;
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
