package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import ui.Printer;

import parser.ArgumentFlagEnum;

public class AddCommand extends Command {
    public AddCommand(Printer printer) {
        super(printer);

        initCommandDetails(new ArgumentFlagEnum[] {
            ArgumentFlagEnum.NAME,
            ArgumentFlagEnum.PROGRAMMINGLANGUAGE,
            ArgumentFlagEnum.DESCRIPTION
        });
    }

    @Override
    public boolean hasAllRequiredArguments() {
        if (descriptionMap.get(ArgumentFlagEnum.NAME) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void execute() throws CommandException {
        String name = descriptionMap.get(ArgumentFlagEnum.NAME);
        String programmingLanguage = descriptionMap.get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        String description = descriptionMap.get(ArgumentFlagEnum.DESCRIPTION);

        if (checkIfNameAlreadyExist(name)) {
            throw new CommandException("Name already existed, please enter another name");
        }

        if (programmingLanguage != null) {
            programmingLanguage = convertToPascalCaseNoSpace(programmingLanguage);
        }

        CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
        CheatSheetList.add(cheatSheet);
        printer.printAddNewCheatSheetMessage(cheatSheet);
    }

    private boolean checkIfNameAlreadyExist(String name) {
        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            if (cs.getCheatSheetName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private String convertToPascalCaseNoSpace(String input) {
        String[] splitInput = input.split(" ");

        for (int i = 0; i < splitInput.length; i++) {
            splitInput[i] = splitInput[i].substring(0, 1).toUpperCase() + splitInput[i].substring(1).toLowerCase();
        }

        return String.join("", splitInput);
    }
}
