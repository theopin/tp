package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;

public class FavouriteCommand extends Command {
    public FavouriteCommand(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap) {
        super(argEnumSet, descriptionMap);
    }

    @Override
    public void execute() throws CommandException {

        int index = 0;
        String name = "";

        CheatSheet cheatSheetToFavourite = null;

        try {
            if (descriptionMap.containsKey(ArgumentFlagEnum.NAME)) {
                name = descriptionMap.get(ArgumentFlagEnum.NAME);
                cheatSheetToFavourite = CheatSheetList.getCheatSheet(name);
            } else if (descriptionMap.containsKey(ArgumentFlagEnum.INDEX)) {
                index = Integer.parseInt(descriptionMap.get(ArgumentFlagEnum.INDEX));
                cheatSheetToFavourite = CheatSheetList.getCheatSheet(index);

            }
            cheatSheetToFavourite.setFavourite(true);
            Printer.printFavouritedCheatSheetMessage(cheatSheetToFavourite);
        } catch (NullPointerException | IndexOutOfBoundsException i) {
            throw new CommandException("Enter valid arguments");
        } catch (NumberFormatException n) {
            throw new CommandException("Enter a valid index");
        }

    }
}

