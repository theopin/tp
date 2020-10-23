package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ViewCommand extends Command {
    public ViewCommand(Printer printer) {
        super(printer);

        initCommandDetails(new ArgumentFlagEnum[] {
            ArgumentFlagEnum.NAME,
            ArgumentFlagEnum.INDEX,
        });
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

            printer.printViewCheatSheetMessage(desiredCheatSheet);
            copyTextToClipboard(desiredCheatSheet.getCheatSheetDetails());
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new CommandException("Please enter a valid index");
        }
    }

    private void copyTextToClipboard(String contentToBeCopied) {
        StringSelection stringSelection = new StringSelection(contentToBeCopied);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
