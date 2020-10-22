package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

public class FavoriteCommand extends Command {
        public FavoriteCommand(Parser parser) {
            super(parser);
        }

    @Override
    public void execute() throws CommandException {

        int index = 0;
        String name = "";

        CheatSheet cheatSheetToFavorite = null;

        try {
            if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.NAME)) {
                name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
                cheatSheetToFavorite = CheatSheetList.getCheatSheet(name);
            } else if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.INDEX)) {
                index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentFlagEnum.INDEX));
                cheatSheetToFavorite = CheatSheetList.getCheatSheet(index);

            }
            cheatSheetToFavorite.setFavorite(true);
            Printer.printFavoritedCheatSheetMessage(cheatSheetToFavorite);
        } catch (NullPointerException | IndexOutOfBoundsException i) {
            throw new CommandException("Enter valid arguments");
        } catch (NumberFormatException n) {
            throw new CommandException("Enter a valid index");
        }

    }
}

