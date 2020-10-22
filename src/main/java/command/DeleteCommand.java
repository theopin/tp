package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;


public class DeleteCommand extends Command {
    public DeleteCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() throws CommandException {
        int index;
        String name;
        CheatSheet cheatSheetToBeDeleted = null;
        try {
            if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.NAME)) {
                name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
                cheatSheetToBeDeleted = CheatSheetList.getCheatSheet(name);
            }  else if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.INDEX)) {
                index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentFlagEnum.INDEX));
                cheatSheetToBeDeleted = CheatSheetList.getCheatSheet(index);
            }

            CheatSheetList.remove(cheatSheetToBeDeleted.getCheatSheetName());
            fileDestroyer.executeFunction(cheatSheetToBeDeleted.getCheatSheetName());
            Printer.printDeleteCheatSheetMessage(cheatSheetToBeDeleted);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new CommandException("Enter valid arguments");
        } catch (NumberFormatException n) {
            throw new CommandException("Enter a valid index");
        }
    }
}
