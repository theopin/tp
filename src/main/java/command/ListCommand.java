package command;

import cheatsheet.CheatSheetList;

import exception.CommandException;

import sort.SortByName;
import ui.Printer;
import ui.TablePrinter;

public class ListCommand extends Command {
    public static final String invoker = "/list";
    private CheatSheetList cheatSheetList;

    public ListCommand(Printer printer, CheatSheetList cheatSheetList) {
        super(printer);
        this.cheatSheetList = cheatSheetList;
    }

    @Override
    public boolean hasAlternativeArgument() {
        return true;
    }

    @Override
    public void execute() throws CommandException {
        cheatSheetList.getList().sort(new SortByName());
        TablePrinter tp = new TablePrinter(cheatSheetList);
        tp.execute();
        SortFilter sortFilter = new SortFilter(cheatSheetList);
        sortFilter.execute();
    }
}

