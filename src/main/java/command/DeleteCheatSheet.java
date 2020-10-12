package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.ArgumentEnum;
import parser.Parser;

public class DeleteCheatSheet extends Command {
    public DeleteCheatSheet(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        String name = "";
        if (parser.getDescriptionMap().containsKey(ArgumentEnum.NAME)) {
            name = parser.getDescriptionMap().get(ArgumentEnum.NAME);
        }  else if (parser.getDescriptionMap().containsKey(ArgumentEnum.INDEX)) {
            int index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentEnum.INDEX));
            name = CheatSheetList.getCheatSheet(index).getCheatSheetName();
        }
        CheatSheetList.remove(name);
    }
}
