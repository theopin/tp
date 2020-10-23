package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

public abstract class FinderCommand extends Command {
    public FinderCommand(Printer printer) {
        super(printer);
    }

    protected CheatSheet getCheatSheetFromNameOrIndex() throws CommandException {
        CheatSheet desiredCheatSheet = null;
        if (descriptionMap.containsKey(ArgumentFlagEnum.NAME)) {
            String name = descriptionMap.get(ArgumentFlagEnum.NAME);
            desiredCheatSheet = CheatSheetList.getCheatSheet(name);
        } else if (descriptionMap.containsKey(ArgumentFlagEnum.INDEX)) {
            int index = Integer.parseInt(descriptionMap.get(ArgumentFlagEnum.INDEX));
            desiredCheatSheet = CheatSheetList.getCheatSheet(index);

        }

        if (desiredCheatSheet == null) {
            throw new CommandException("Please enter a valid name or an index");
        }

        return desiredCheatSheet;
    }
}

