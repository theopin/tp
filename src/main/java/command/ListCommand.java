package command;

import cheatsheet.CheatSheetList;
import sort.SortByLanguage;
import sort.SortByLanguageRev;
import sort.SortByName;
import sort.SortByNameRev;
import ui.Printer;

import java.util.Collections;
import java.util.Scanner;

public class ListCommand extends Command {
    public ListCommand(Printer printer) {
        super(printer);

        initCommandDetails(null);
    }

    @Override
    public boolean hasAllRequiredArguments() {
        return true;
    }

    @Override
    public void execute() {
        CheatSheetList.getCheatSheetList().sort(new SortByName());
        printer.printCheatSheetList();
        askForSortingConfigAndPrint();
    }

    private void askForSortingConfigAndPrint() {
        final String promptSortConfig = "Sort filter (na: name ascending, la: language ascending, nd: name descending"
                + ", ld: language descending or <enter> to skip)";

        printer.print(promptSortConfig);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("")) {
            switch (input) {
            case "na":
                CheatSheetList.getCheatSheetList().sort(new SortByName());
                printer.print("Sorted name in ascending order");
                break;
            case "la":
                CheatSheetList.getCheatSheetList().sort(new SortByLanguage());
                printer.print("Sorted language in ascending order");
                break;
            case "nd":
                CheatSheetList.getCheatSheetList().sort(new SortByNameRev());
                printer.print("Sorted name in descending order");
                break;
            case "ld":
                CheatSheetList.getCheatSheetList().sort(new SortByLanguageRev());
                printer.print("Sorted language in descending order");
                break;
            default:
                CheatSheetList.getCheatSheetList().sort(new SortByName());
            }
            printer.printCheatSheetList();
            printer.print(promptSortConfig);
            input = scanner.nextLine();
        }
    }
}