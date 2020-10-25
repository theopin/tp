/*package command;

import cheatsheet.CheatSheetList;
import sort.SortByLanguage;
import sort.SortByName;
import ui.Printer;

import java.util.Scanner;

public class ListCommand extends Command {
    public ListCommand(Printer printer) {
        super(printer);

        //initCommandDetails(null);
    }

    @Override
    public boolean hasOneAlternativeArgument() {
        return true;
    }

    @Override
    public void execute() {
        printer.printCheatSheetList();
        askForSortingConfigAndPrint();
    }

    private void askForSortingConfigAndPrint() {
        printer.print("Sort filter (na: name ascending, la: language ascending, nd: name descending"
                + ", ld: language descending or <<enter>> to skip)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.isEmpty()) {
            switch (input) {
            case "na":
                CheatSheetList.getCheatSheetList().sort(new SortByName());
                printer.print("Currently sorting name in ascending order");
                break;
            case "la":
                CheatSheetList.getCheatSheetList().sort(new SortByLanguage());
                break;
            case "nd":
                CheatSheetList.getCheatSheetList().sort(new SortByName().reversed());
                break;
            case "ld":
                CheatSheetList.getCheatSheetList().sort(new SortByLanguage().reversed());
                break;
            default:
                CheatSheetList.getCheatSheetList().sort(new SortByName());
            }
            printer.printCheatSheetList();
            input = scanner.nextLine();
        }
    }
}*/

package command;

import cheatsheet.CheatSheetList;
import sort.SortByLanguage;
import sort.SortByLanguageRev;
import sort.SortByName;
import sort.SortByNameRev;
import ui.ConsoleColorsEnum;
import ui.Printer;

import java.util.Scanner;

public class ListCommand extends Command {
    public static final String invoker = "/list";

    public ListCommand(Printer printer) {
        super(printer);
    }

    @Override
    public boolean hasAlternativeArgument() {
        return true;
    }

    @Override
    public void execute() {
        CheatSheetList.getList().sort(new SortByName());
        printer.printCheatSheetList();
        askForSortingConfigAndPrint();
    }

    private void askForSortingConfigAndPrint() {
        final String promptSortConfig = ConsoleColorsEnum.RED_TEXT
            + "Sort filter (na: name ascending, la: language ascending, nd: name descending" + ", ld: "
            + "language descending or <<enter>> to skip)" + ConsoleColorsEnum.RESET_TEXT;

        printer.print(promptSortConfig);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.isEmpty()) {
            switch (input) {
            case "na":
                CheatSheetList.getList().sort(new SortByName());
                printer.print("Sorted name in ascending order");
                break;
            case "la":
                CheatSheetList.getList().sort(new SortByLanguage());
                printer.print("Sorted language in ascending order");
                break;
            case "nd":
                CheatSheetList.getList().sort(new SortByNameRev());
                printer.print("Sorted name in descending order");
                break;
            case "ld":
                CheatSheetList.getList().sort(new SortByLanguageRev());
                printer.print("Sorted language in descending order");
                break;
            default:
                CheatSheetList.getList().sort(new SortByName());
            }
            printer.printCheatSheetList();
            printer.print(promptSortConfig);
            input = scanner.nextLine();
        }
    }
}

