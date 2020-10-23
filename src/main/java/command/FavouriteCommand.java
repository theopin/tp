package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

public class FavouriteCommand extends Command {
    public FavouriteCommand(Printer printer) {
        super(printer);

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

