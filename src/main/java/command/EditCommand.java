package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import editor.Editor;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

import java.util.HashMap;

public class EditCommand extends Command {
    public EditCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer) {
        super(descriptionMap, printer);
    }

    @Override
    public void execute() throws CommandException {
        CheatSheet desiredCheatSheet = null;
        try {
            if (descriptionMap.containsKey(ArgumentFlagEnum.NAME)) {
                String name = descriptionMap.get(ArgumentFlagEnum.NAME);
                desiredCheatSheet = CheatSheetList.getCheatSheet(name);
            } else if (descriptionMap.containsKey(ArgumentFlagEnum.INDEX)) {
                int index = Integer.parseInt(descriptionMap.get(ArgumentFlagEnum.INDEX));
                desiredCheatSheet = CheatSheetList.getCheatSheet(index);
            }
            if (desiredCheatSheet == null) {
                throw new CommandException("Please enter a name or an index");
            }
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
        while(!contentEditor.isEditDone()){
            printer.print("Waiting for user input...");
        }
        desiredCheatSheet.setCheatSheetDetails(contentEditor.getContent());
    }
}
