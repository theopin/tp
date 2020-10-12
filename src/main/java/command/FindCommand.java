package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.ArgumentFlagEnum;
import parser.Parser;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        String keyword = parser.getDescriptionMap().get(ArgumentFlagEnum.DESCRIPTION);

        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            if (cs.getCheatSheetName().contains(keyword)) {
                System.out.println(cs);
            }
        }
    }
}
