package command;

import cheatsheet.CheatSheetList;
import exception.CommandException;
import sort.SortBySubject;
import sort.SortBySubjectRev;
import sort.SortByName;
import sort.SortByNameRev;
import ui.ConsoleColorsEnum;
import ui.Printer;
import ui.TablePrinter;

import java.util.Scanner;

public class SortFilter {
    final String promptSortConfig = ConsoleColorsEnum.RED_TEXT
        + "Sort filter (1: name ascending, 2: language ascending, 3: name descending" + ", 4: "
        + "language descending or anything else to skip)" + ConsoleColorsEnum.RESET_TEXT;
    Printer printer;
    CheatSheetList cheatSheetList;

    public SortFilter(CheatSheetList cheatSheetList) {
        this.cheatSheetList = cheatSheetList;
        printer = new Printer();
    }

    public void execute(TablePrinter tp) throws CommandException {
        do {
            askForInput();
            tp.execute();
        } while (true);
    }

    public void execute() throws CommandException {
        do {
            askForInput();
            TablePrinter tp = new TablePrinter(cheatSheetList.getList());
            tp.execute();
        } while (true);
    }

    private void askForInput() throws CommandException {
        printer.print(promptSortConfig);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
        case "1":
            cheatSheetList.getList().sort(new SortByName());
            printer.print("Sorted name in ascending order");
            break;
        case "2":
            cheatSheetList.getList().sort(new SortBySubject());
            printer.print("Sorted language in ascending order");
            break;
        case "3":
            cheatSheetList.getList().sort(new SortByNameRev());
            printer.print("Sorted name in descending order");
            break;
        case "4":
            cheatSheetList.getList().sort(new SortBySubjectRev());
            printer.print("Sorted language in descending order");
            break;
        default:
            throw new CommandException("Exiting list command ...");
        }
    }
}
