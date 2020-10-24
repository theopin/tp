package command;

import cheatsheet.CheatSheet;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ViewCommand extends FinderCommand {
    public ViewCommand(Printer printer) {
        super(printer);

        /*initCommandDetails(new ArgumentFlagEnum[] {
            ArgumentFlagEnum.NAME,
            ArgumentFlagEnum.INDEX,
        });*/
        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.INDEX, null);
        requiredArguments.add(ArgumentFlagEnum.NAME);
        requiredArguments.add(ArgumentFlagEnum.INDEX);
    }
    /*
    @Override
    public boolean hasAllRequiredArguments() {
        return descriptionMap.get(ArgumentFlagEnum.NAME) != null
            || descriptionMap.get(ArgumentFlagEnum.INDEX) != null;
    }
    */

    @Override
    public void execute() throws CommandException {
        try {
            CheatSheet desiredCheatSheet = getCheatSheetFromNameOrIndex();
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
