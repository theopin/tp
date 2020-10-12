package command;

import cheatsheet.CheatSheetList;
import parser.Parser;

public class ListCommand extends Command {
    public ListCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        CheatSheetList.printCheatSheetNames();
    }
}
