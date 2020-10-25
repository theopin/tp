package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;

public abstract class FinderCommand extends Command {
    public FinderCommand(Printer printer) {
        super(printer);
    }

    protected CheatSheet getCheatSheetFromNameOrIndex() throws CommandException {
        CheatSheet desiredCheatSheet = null;
        if (flagsToDescriptions.get(CommandFlag.NAME) != null) {
            String name = flagsToDescriptions.get(CommandFlag.NAME);
            desiredCheatSheet = CheatSheetList.get(name);
        } else if (flagsToDescriptions.get(CommandFlag.INDEX) != null) {
            int index = Integer.parseInt(flagsToDescriptions.get(CommandFlag.INDEX));
            desiredCheatSheet = CheatSheetList.get(index);
        }

        if (desiredCheatSheet == null) {
            throw new CommandException("Please enter a valid name or an index");
        }

        return desiredCheatSheet;
    }
}

