package command;

import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.Parser;

public class DeleteCheatSheet extends Command {
    public DeleteCheatSheet(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        String name = "";
        if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.NAME)) {
            name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
        }  else if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.INDEX)) {
            int index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentFlagEnum.INDEX));
            name = CheatSheetList.getCheatSheet(index).getCheatSheetName();
        }
        CheatSheetList.remove(name);
    }
}
