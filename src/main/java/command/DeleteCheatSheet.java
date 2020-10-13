package command;

import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

public class DeleteCheatSheet extends Command {
    public DeleteCheatSheet(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        int index = 0;
        String name = "";
        if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.NAME)) {
            name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
            // this for loop is temporary

            for (int i = 0; i < CheatSheetList.getCheatSheetList().size(); i++) {
                if (CheatSheetList.getCheatSheetList().get(i).getCheatSheetName().equals(name)) {
                    index = i + 1;
                    break;
                }
            }
        } else if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.INDEX)) {
            index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentFlagEnum.INDEX));
            name = CheatSheetList.getCheatSheet(index).getCheatSheetName();
        }

        Printer.printDeleteCheatSheetMessage(CheatSheetList.getCheatSheet(index));
        CheatSheetList.remove(name);
    }
}
