package command;

import cheatsheet.CheatSheetList;
import parser.Parser;

public class ListCommand extends Command {
    public ListCommand(Parser parser) {
        super(parser);
    }

    // todo: need to ask adhy whether he can attach index to cheatsheet

    @Override
    public void execute() {
        System.out.println(CheatSheetList.printCheatSheetNames());
    }
}
