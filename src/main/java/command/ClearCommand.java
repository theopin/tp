package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.Parser;
import ui.Printer;


public class ClearCommand extends Command {
    public ClearCommand(Parser parser) {
        super(parser);
    }
    // todo: ask adhy whether he can add one more function to delete all cheatsheets

    @Override
    public void execute() {
        Printer.printClearCheatSheetMessage(CheatSheetList.getSize());
        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            CheatSheetList.remove(cs.getCheatSheetName());
            Printer.printCheatSheet(cs);
        }
    }
}
