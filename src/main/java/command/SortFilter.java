package command;

import cheatsheet.CheatSheetList;
import exception.CommandException;
import sort.SortByLanguage;
import sort.SortByLanguageRev;
import sort.SortByName;
import sort.SortByNameRev;
import ui.ConsoleColorsEnum;
import ui.Printer;

import java.io.IOException;
import java.util.Scanner;

public class SortFilter {
    final String promptSortConfig = ConsoleColorsEnum.RED_TEXT
        + "Sort filter (1: name ascending, 2: language ascending, 3: name descending" + ", 4: "
        + "language descending or anything else to skip)" + ConsoleColorsEnum.RESET_TEXT;
    Printer printer;

    public SortFilter() {
        printer = new Printer();
    }

    public void execute() throws CommandException, IOException {
        printer.print(promptSortConfig);
        do {
            askForInput();
        } while (true);
    }

    private void askForInput() throws CommandException, IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
        case "1":
            CheatSheetList.getList().sort(new SortByName());
            printer.print("Sorted name in ascending order");
            break;
        case "2":
            CheatSheetList.getList().sort(new SortByLanguage());
            printer.print("Sorted language in ascending order");
            break;
        case "3":
            CheatSheetList.getList().sort(new SortByNameRev());
            printer.print("Sorted name in descending order");
            break;
        case "4":
            CheatSheetList.getList().sort(new SortByLanguageRev());
            printer.print("Sorted language in descending order");
            break;
        default:
            throw new CommandException("Exiting list command ...");
        }
        printer.printCheatSheetList();
        printer.print(promptSortConfig);
    }
}
