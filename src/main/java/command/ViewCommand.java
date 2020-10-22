package command;

import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewCommand extends Command {
    public ViewCommand(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap) {
        super(argEnumSet, descriptionMap);
    }

    @Override
    public void execute() throws CommandException {
        int index = 0;
        try {
            if (descriptionMap.containsKey(ArgumentFlagEnum.NAME)) {
                String name = descriptionMap.get(ArgumentFlagEnum.NAME);
                for (int i = 0; i < CheatSheetList.getSize(); i++) {
                    if (CheatSheetList.getCheatSheet(i).getCheatSheetName().equals(name)) {
                        index = i + 1;
                        break;
                    }
                }
            } else if (descriptionMap.containsKey(ArgumentFlagEnum.INDEX)) {
                index = Integer.parseInt(descriptionMap.get(ArgumentFlagEnum.INDEX));
            }
            Printer.printViewCheatSheetMessage(CheatSheetList.getCheatSheet(index));
            copyTextToClipboard(CheatSheetList.getCheatSheet(index).getCheatSheetDetails());
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
