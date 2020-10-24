package command;

import cheatsheet.CheatSheet;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

public class FavouriteCommand extends FinderCommand {
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
        try {
            CheatSheet cheatSheetToFavourite = getCheatSheetFromNameOrIndex();
            cheatSheetToFavourite.setFavourite(true);
            printer.printFavouritedCheatSheetMessage(cheatSheetToFavourite);
        } catch (NullPointerException | IndexOutOfBoundsException i) {
            throw new CommandException("Please enter a valid name or an index");
        } catch (NumberFormatException n) {
            throw new CommandException("Please enter a valid index");
        }

    }
}

