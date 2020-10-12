package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.Parser;

public class ClearCheatSheet extends Command {
    public ClearCheatSheet(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            CheatSheetList.remove(cs.getCheatSheetName());
        }
    }
}
