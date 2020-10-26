package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;

import java.util.ArrayList;

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

    protected boolean checkCheatSheetExistsInCheatSheetList(CheatSheet cs, String subject,
                                                            String keyword) throws CommandException {
        if (subject != null && keyword == null) {
            return cs.getSubject().contains(subject);
        } else if (keyword != null && subject == null) {
            return cs.getDetails().contains(keyword);
        } else if (subject != null) {
            return cs.getSubject().contains(subject) && cs.getDetails().contains(keyword);
        } else {
            throw new CommandException("Please enter at least an argument");
        }
    }
}

