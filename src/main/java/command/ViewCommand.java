package command;

import cheatsheet.CheatSheet;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ViewCommand extends FinderCommand {
    public static final String invoker = "/view";

    public ViewCommand(Printer printer) {
        super(printer);

        descriptionMap.put(ArgumentFlagEnum.NAME, null);
        descriptionMap.put(ArgumentFlagEnum.INDEX, null);
        alternativeArguments.add(ArgumentFlagEnum.NAME);
        alternativeArguments.add(ArgumentFlagEnum.INDEX);
    }

    @Override
    public void execute() throws CommandException {
        try {
            CheatSheet desiredCheatSheet = getCheatSheetFromNameOrIndex();
            printer.printViewCheatSheetMessage(desiredCheatSheet);
            copyTextToClipboard(desiredCheatSheet.getDetails());
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
