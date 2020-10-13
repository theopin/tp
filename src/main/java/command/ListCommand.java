package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.Parser;
import ui.Printer;

public class ListCommand extends Command {
    public ListCommand(Parser parser) {
        super(parser);
    }

    // todo: need to ask adhy whether he can attach index to cheatsheet

    @Override
    public void execute() {
        for (int i = 1; i <= CheatSheetList.getSize(); i++) {
            System.out.println(i + ". " + CheatSheetList.getCheatSheet(i).getCheatSheetName() + " (ProgrammingLanguage: "
                    + CheatSheetList.getCheatSheet(i).getCheatSheetProgrammingLanguage() + ")");
        }
    }
}
