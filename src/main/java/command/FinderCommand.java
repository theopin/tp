package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;

public abstract class FinderCommand extends Command {
    protected CheatSheetList cheatSheetList;

    public FinderCommand(Printer printer, CheatSheetList cheatSheetList) {
        super(printer);
        this.cheatSheetList = cheatSheetList;
    }

    protected CheatSheet getCheatSheetFromNameOrIndex() throws CommandException {
        CheatSheet desiredCheatSheet = null;
        String name = flagsToDescriptions.get(CommandFlag.NAME);
        String index = flagsToDescriptions.get(CommandFlag.INDEX);
        if (name != null && index == null) {
            desiredCheatSheet = cheatSheetList.get(name);
        } else if (index != null && name == null) {
            desiredCheatSheet = cheatSheetList.get(Integer.parseInt(index));
        } else if (index != null) {
            if (cheatSheetList.get(name).equals(cheatSheetList.get(Integer.parseInt(index)))) {
                desiredCheatSheet = cheatSheetList.get(name);
            }
        }

        if (desiredCheatSheet == null) {
            throw new CommandException("Please enter a valid name or an index");
        }

        return desiredCheatSheet;
    }

    public boolean checkCheatSheetExistsInCheatSheetList(CheatSheet cs, String name, String subject,
                                                            String keyword) throws CommandException {
        if (subject != null && keyword == null && name == null) {
            return cs.getSubject().contains(subject);
        } else if (keyword != null && subject == null && name == null) {
            return cs.getDetails().contains(keyword);
        } else if (subject != null && keyword != null && name == null) {
            return cs.getSubject().contains(subject) && cs.getDetails().contains(keyword);
        } else {
            throw new CommandException("Please enter at least an argument");
        }
    }
}

