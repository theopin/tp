package command;

import cheatsheet.CheatSheet;
import editor.Editor;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

public class EditCommand extends FinderCommand {
    public static final String invoker = "/edit";
    Editor editor;

    public EditCommand(Printer printer, Editor editor) {
        super(printer);
        this.editor = editor;

        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.INDEX, null);
    }

    @Override
    public boolean hasOneAlternativeArgument() {
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

            callContentEditor(desiredCheatSheet);

            printer.printViewCheatSheetMessage(desiredCheatSheet);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new CommandException("Please enter a valid index");
        }
    }

    private void callContentEditor(CheatSheet desiredCheatSheet) {
        editor.open();
        editor.setContent(desiredCheatSheet.getDetails());
        editor.waitForClose();

        desiredCheatSheet.setDetails(editor.getContent());
    }
}
