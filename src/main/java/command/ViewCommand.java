package command;

import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

public class ViewCommand extends Command {
    public ViewCommand(Parser parser) {
        super(parser);
    }

    // todo: need to implement it to show cheatsheet content

    @Override
    public void execute() throws CommandException {
        int index = 0;
        if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.NAME)) {
            String name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
            for (int i = 0; i < CheatSheetList.getSize(); i++) {
                if (CheatSheetList.getCheatSheet(i).getCheatSheetName().equals(name)) {
                    index = i + 1;
                    break;
                }
            }
        }  else if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.INDEX)) {
            index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentFlagEnum.INDEX));
        }
        try {
            Printer.printViewCheatSheetMessage(CheatSheetList.getCheatSheet(index));
            System.out.println(CheatSheetList.getCheatSheet(index).getCheatSheetDetails());
        } catch (IndexOutOfBoundsException i) {
            throw new CommandException("Please enter a valid index");
        }
    }
}
