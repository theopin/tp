package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;

/**
 * Command to set a cheat sheet as favourite.
 */
public class FavouriteCommand extends FinderCommand {
    public static final String invoker = "/fav";

    /**
     * Constructor for the FavouriteCommand.
     * Required argument: either NAME or INDEX
     *
     * @param printer        The printer object to handle user interaction
     * @param cheatSheetList The current list of cheat sheets
     */
    public FavouriteCommand(Printer printer, CheatSheetList cheatSheetList) {
        super(printer, cheatSheetList);

        flagsToDescriptions.put(CommandFlag.NAME, null);
        flagsToDescriptions.put(CommandFlag.INDEX, null);
        alternativeArguments.add(CommandFlag.NAME);
        alternativeArguments.add(CommandFlag.INDEX);
    }

    /**
     * Sets a cheat sheet as favourite.
     * getCheatSheetFromNameOrIndex() from FinderCommand will retrieve the desired cheat sheet
     * and the isFavourite attribute will be set to true.
     *
     * @throws CommandException if the input is not valid
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

