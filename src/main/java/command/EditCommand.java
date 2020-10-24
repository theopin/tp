package command;

import cheatsheet.CheatSheet;
import editor.Editor;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

public class EditCommand extends FinderCommand {
    public EditCommand(Printer printer) {
        super(printer);

        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.INDEX, null);
    }

    @Override
    public boolean hasAllRequiredArguments() {
        if (descriptionMap.get(ArgumentFlagEnum.NAME) != null
                || descriptionMap.get(ArgumentFlagEnum.INDEX) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void execute() throws CommandException {
        try {
            CheatSheet desiredCheatSheet = getCheatSheetFromNameOrIndex();

            // This line calls the
            callContentEditor(desiredCheatSheet);

            printer.printViewCheatSheetMessage(desiredCheatSheet);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new CommandException("Please enter a valid index");
        }
    }

    private void callContentEditor(CheatSheet desiredCheatSheet) {
        String cheatSheetContent = desiredCheatSheet.getCheatSheetDetails();
        Editor contentEditor = new Editor(cheatSheetContent);
        contentEditor.showWindow();
        while (contentEditor.isEditing()) {
            printer.print("Waiting for user input...");
        }

        desiredCheatSheet.setCheatSheetDetails(contentEditor.getContent());
    }
}
