package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import editor.Editor;
import exception.CommandException;
import parser.ArgumentFlagEnum;

import ui.Printer;

import java.util.concurrent.TimeUnit;

public class AddCommand extends Command {
    public AddCommand(Printer printer) {
        super(printer);

        /*initCommandDetails(new ArgumentFlagEnum[] {
            ArgumentFlagEnum.NAME,
            ArgumentFlagEnum.PROGRAMMINGLANGUAGE,
            ArgumentFlagEnum.DESCRIPTION
        });*/
        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.PROGRAMMINGLANGUAGE, null);
        // descriptionMap.put(ArgumentFlagEnum.DESCRIPTION, null);
        requiredArguments.add(ArgumentFlagEnum.NAME);
    }
    /*
    @Override
    public boolean hasAllRequiredArguments() {
        return descriptionMap.get(ArgumentFlagEnum.NAME) != null;
    }
    */

    @Override
    public void execute() throws CommandException {
        String name = descriptionMap.get(ArgumentFlagEnum.NAME);
        String programmingLanguage = descriptionMap.get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        String description = callContentEditor();

        if (checkIfNameAlreadyExist(name)) {
            throw new CommandException("Name already existed, please enter another name");
        }

        if (programmingLanguage != null) {
            programmingLanguage = convertToPascalCaseNoSpace(programmingLanguage);
        }
        System.out.println(description);
        CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
        CheatSheetList.add(cheatSheet);

        printer.printAddNewCheatSheetMessage(cheatSheet);
    }

    private String callContentEditor() {
        String content;
        Editor contentEditor = new Editor();
        System.out.println("Waiting for user input...");
        do {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                assert false;
            }
            content = contentEditor.getContent();
        } while (!contentEditor.isEditDone());
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

    private String convertToPascalCaseNoSpace(String input) throws CommandException {
        try {
            String[] splitInput = input.split(" ");
            for (int i = 0; i < splitInput.length; i++) {
                splitInput[i] = splitInput[i].substring(0, 1).toUpperCase() + splitInput[i].substring(1).toLowerCase();
            }

            return String.join("", splitInput);
        } catch (StringIndexOutOfBoundsException s) {
            throw new CommandException(" why extra space?");
        }
    }
}
