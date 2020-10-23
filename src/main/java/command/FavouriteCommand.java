package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

import java.util.HashMap;

public class FavouriteCommand extends Command {
    public FavouriteCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer) {
        super(descriptionMap, printer);
    }

    @Override
    public void execute() throws CommandException {
        int index;
        String name;

        CheatSheet cheatSheetToFavourite = null;

        try {
            if (descriptionMap.containsKey(ArgumentFlagEnum.NAME)) {
                name = descriptionMap.get(ArgumentFlagEnum.NAME);
                cheatSheetToFavourite = CheatSheetList.getCheatSheet(name);
            } else if (descriptionMap.containsKey(ArgumentFlagEnum.INDEX)) {
                index = Integer.parseInt(descriptionMap.get(ArgumentFlagEnum.INDEX));
                cheatSheetToFavourite = CheatSheetList.getCheatSheet(index);

            }

            if (cheatSheetToFavourite == null) {
                throw new CommandException("Please enter a name or an index");
            }

            cheatSheetToFavourite.setFavourite(true);
            printer.printFavouritedCheatSheetMessage(cheatSheetToFavourite);
        } catch (NullPointerException | IndexOutOfBoundsException i) {
            throw new CommandException("Please enter valid arguments");
        } catch (NumberFormatException n) {
            throw new CommandException("Please enter a valid index");
        }

    }
}

