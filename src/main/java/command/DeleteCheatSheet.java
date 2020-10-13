package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;


public class DeleteCheatSheet extends Command {
    public DeleteCheatSheet(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() throws CommandException {
        int index = 0;
        String name = "";
        CheatSheet cheatSheetToBeDeleted;
        try {
            if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.NAME)) {
                name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
                // this for loop is temporary

                for (int i = 0; i < CheatSheetList.getSize(); i++) {
                    if (CheatSheetList.getCheatSheet(i).getCheatSheetName().equals(name)) {
                        index = i;
                        break;
                    }
                }

            }  else if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.INDEX)) {
                index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentFlagEnum.INDEX));
                name = CheatSheetList.getCheatSheet(index).getCheatSheetName();
            }

            cheatSheetToBeDeleted = CheatSheetList.getCheatSheet(index);
            CheatSheetList.remove(name);
            fileDestroyer.executeFunction(name);
            Printer.printDeleteCheatSheetMessage(cheatSheetToBeDeleted);
        } catch (IndexOutOfBoundsException i) {
            throw new CommandException("Enter a valid argument or name");
        } catch (NumberFormatException n) {
            throw new CommandException("Enter a valid index");
        }

    }
}
