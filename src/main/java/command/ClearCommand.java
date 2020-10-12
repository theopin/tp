package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.Parser;


public class ClearCommand extends Command {
    public ClearCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            CheatSheetList.remove(cs.getCheatSheetName());
        }
    }
}
