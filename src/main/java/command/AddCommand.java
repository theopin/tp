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

        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.SUBJECT, null);
        alternativeArguments.add(ArgumentFlagEnum.NAME);
    }

    @Override
    public void execute() throws CommandException {
        String name = descriptionMap.get(ArgumentFlagEnum.NAME);
        String subject = descriptionMap.get(ArgumentFlagEnum.SUBJECT);
        String description = callContentEditor();

        if (checkIfNameAlreadyExist(name)) {
            throw new CommandException("Name already existed, please enter another name");
        }

        if (subject != null) {
            subject = convertToPascalCaseNoSpace(subject);
        }
        printer.print(description);
        CheatSheet cheatSheet = new CheatSheet(name, subject, description);
        CheatSheetList.add(cheatSheet);

        printer.printAddNewCheatSheetMessage(cheatSheet);
    }

    private String callContentEditor() {
        String content;
        Editor contentEditor = new Editor();
        printer.print("Waiting for user input...");
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
        for (CheatSheet cs : CheatSheetList.getList()) {
            if (cs.getName().equals(name)) {
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
            throw new CommandException("Why is there extra space?");
        }
    }
}
