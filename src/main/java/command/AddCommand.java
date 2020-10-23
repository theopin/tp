package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import editor.Editor;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;
import java.util.HashMap;

public class AddCommand extends Command {
    public AddCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer) {
        super(descriptionMap, printer);
    }

    @Override
    public void execute() throws CommandException {
        String name = descriptionMap.get(ArgumentFlagEnum.NAME);
        String programmingLanguage = descriptionMap.get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        String description = callContentEditor();

        if (name == null) {
            throw new CommandException("Please enter a name");
        } else if (checkIfNameAlreadyExist(name)) {
            throw new CommandException("Name already existed, please enter another name");
        }
        CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
        CheatSheetList.add(cheatSheet);

        printer.printAddNewCheatSheetMessage(cheatSheet);
    }

    private String callContentEditor() {
        String content;
        Editor contentEditor = new Editor();
        do {
            // needs to figure out how to stop the infinite loop
            System.out.println("Waiting for user input...");
            content = contentEditor.getContent();
        } while (content == null);
        return content;
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
