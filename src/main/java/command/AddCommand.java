package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import editor.Editor;
import exception.CommandException;
import parser.ArgumentFlagEnum;

import ui.Printer;

public class AddCommand extends Command {
    Editor editor;

    public AddCommand(Printer printer, Editor editor) {
        super(printer);
        this.editor = editor;

        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.SUBJECT, null);
        alternativeArguments.add(ArgumentFlagEnum.NAME);
    }

    @Override
    public void execute() throws CommandException {
        String name = descriptionMap.get(ArgumentFlagEnum.NAME);
        if (checkIfNameAlreadyExist(name)) {
            throw new CommandException("Name already existed, please enter another name");
        }

        String subject = descriptionMap.get(ArgumentFlagEnum.SUBJECT);
        if (subject != null) {
            subject = convertToPascalCaseNoSpace(subject);
        }

        callContentEditor();
        String description = editor.getContent();

        printer.print(description);
        CheatSheet cheatSheet = new CheatSheet(name, subject, description);
        CheatSheetList.add(cheatSheet);

        printer.printAddNewCheatSheetMessage(cheatSheet);
    }

    private void callContentEditor() {
        editor.open();
        editor.waitForClose();
    }

    private boolean checkIfNameAlreadyExist(String name) {
        for (CheatSheet cs : CheatSheetList.getList()) {
            if (cs.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private String convertToPascalCaseNoSpace(String input) throws CommandException {
        String[] splitInput = input.split("\\p{IsWhite_Space}+");
        for (int i = 0; i < splitInput.length; i++) {
            splitInput[i] = splitInput[i].substring(0, 1).toUpperCase() + splitInput[i].substring(1).toLowerCase();
        }

        return String.join("", splitInput);
    }
}
