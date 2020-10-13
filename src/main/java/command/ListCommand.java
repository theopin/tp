package command;

<<<<<<< HEAD
import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
=======
>>>>>>> a36b5c4cc93357943ee51b13e0cf58f5a3f95893
import parser.Parser;
import ui.Printer;

public class ListCommand extends Command {
    public ListCommand(Parser parser) {
        super(parser);
    }

    // todo: need to ask adhy whether he can attach index to cheatsheet

    @Override
    public void execute() {
        Printer.printCheatSheetList();
    }
}
