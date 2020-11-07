package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import editor.Editor;
import exception.CommandException;
import exception.EditorException;
import parser.CommandFlag;
import ui.Printer;

public class EditCommand extends FinderCommand {
    private final Editor editor;

    public static final String invoker = "/edit";

    public EditCommand(Printer printer, CheatSheetList cheatSheetList, Editor editor) {
        super(printer, cheatSheetList);
        this.editor = editor;
        flagsToDescriptions.put(CommandFlag.NAME, null);
        flagsToDescriptions.put(CommandFlag.INDEX, null);
        alternativeArguments.add(CommandFlag.NAME);
        alternativeArguments.add(CommandFlag.INDEX);
    }

    @Override
    public boolean hasAlternativeArgument() {
        return flagsToDescriptions.get(CommandFlag.NAME) != null
                || flagsToDescriptions.get(CommandFlag.INDEX) != null;
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
        editor.setEditingContentAttributes(desiredCheatSheet.getName(), desiredCheatSheet.getSubject());
        editor.open();
        editor.setContent(desiredCheatSheet.getDetails());
        editor.waitForClose();

        try {
            desiredCheatSheet.setDetails(editor.getContent());
        } catch (EditorException e) {
            printer.print(e.getMessage());
        }
    }
}
