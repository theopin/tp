package command;

import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.Parser;

public class ViewCommand extends Command {
    public ViewCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        int index = Integer.parseInt(parser.getDescriptionMap().get(ArgumentFlagEnum.INDEX));
        System.out.println(CheatSheetList.getCheatSheet(index));
    }
}
