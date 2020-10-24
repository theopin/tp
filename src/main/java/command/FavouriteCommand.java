package command;

import cheatsheet.CheatSheet;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

public class FavouriteCommand extends FinderCommand {
    public FavouriteCommand(Printer printer) {
        super(printer);

        /*initCommandDetails(new ArgumentFlagEnum[] {
            ArgumentFlagEnum.NAME,
            ArgumentFlagEnum.INDEX,
        });*/
        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.INDEX, null);
        requiredArguments.add(ArgumentFlagEnum.NAME);
        requiredArguments.add(ArgumentFlagEnum.INDEX);
    }
    /*
    @Override
    public boolean hasAllRequiredArguments() {
        return descriptionMap.get(ArgumentFlagEnum.NAME) != null
            || descriptionMap.get(ArgumentFlagEnum.INDEX) != null;
    }
    */

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

