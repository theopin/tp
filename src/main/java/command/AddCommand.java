package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import exception.CommandException;
import ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;

public class AddCommand extends Command {
    public AddCommand(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap) {
        super(argEnumSet, descriptionMap);
    }

    @Override
    public void execute() throws CommandException {
        String name = descriptionMap.get(ArgumentFlagEnum.NAME);
        String programmingLanguage = descriptionMap.get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        String description = descriptionMap.get(ArgumentFlagEnum.DESCRIPTION);

        if (name == null) {
            throw new CommandException("Please enter a name");
        } else if (checkIfNameAlreadyExist(name)) {
            throw new CommandException("Name already existed, please enter another name");
        }

        CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
        CheatSheetList.add(cheatSheet);
        Printer.printAddNewCheatSheetMessage(cheatSheet);
    }

    private boolean checkIfNameAlreadyExist(String name) {
        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            if (cs.getCheatSheetName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
