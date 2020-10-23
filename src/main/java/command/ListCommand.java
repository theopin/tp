package command;

import parser.ArgumentFlagEnum;
import cheatsheet.CheatSheetList;
import sort.SortByName;
import sort.SortByLanguage;
import ui.Printer;

import java.util.HashMap;
import java.util.Scanner;

public class ListCommand extends Command {
    public ListCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer) {
        super(descriptionMap, printer);
    }

    @Override
    public void execute() {
        printer.printCheatSheetList();
        askForSortingConfigAndPrint();
    }

    private void askForSortingConfigAndPrint() {
        printer.print("Sort filter (na: name ascending, la: language ascending, nd: name descending"
            + ", ld: language descending or <enter> to skip)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("q")) {
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
}

