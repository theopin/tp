package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.Parser;

public class ClearCheetSheet extends Command {
    public ClearCheetSheet(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            CheatSheetList.remove(cs.getCheatSheetName());
        }
    }
}
