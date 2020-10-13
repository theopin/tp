package command;

import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

public class ViewCommand extends Command {
    public ViewCommand(Parser parser) {
        super(parser);
    }

    // todo: need to implement it to show cheatsheet content

    @Override
    public void execute() {
        int index = 0;
        if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.NAME)) {
            String name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
            for (int i = 0; i < CheatSheetList.getCheatSheetList().size(); i++) {
                if (CheatSheetList.getCheatSheetList().get(i).getCheatSheetName().equals(name)) {
                    index = i + 1;
                    break;
                }
            }
        } else if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.INDEX)) {
            index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentFlagEnum.INDEX));
        }
        Printer.printViewCheatSheetMessage(CheatSheetList.getCheatSheet(index));
    }
}
