package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import editor.Editor;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

public class AddCommand extends Command {
    public AddCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() throws CommandException {
        boolean isExit;
        String name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
        String programmingLanguage = parser.getDescriptionMap().get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        //String description = parser.getDescriptionMap().get(ArgumentFlagEnum.DESCRIPTION);
        Editor contentEditor = new Editor();
        do {
            //wait for the program to finish
            // needs to figure out how to stop the infinite loop
            System.out.println("Loading....");
            isExit = contentEditor.isEditDone();
        } while (!isExit);
        System.out.println("HELLO IM HERE");
        String description = contentEditor.getContent();
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
