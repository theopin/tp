package command;

import parser.ArgumentFlagEnum;
import sort.SortByName;
import sort.SortByLanguage;
import cheatsheet.CheatSheetList;
import parser.Parser;
import ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListCommand extends Command {
    public ListCommand(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap) {
        super(argEnumSet, descriptionMap);
    }

    @Override
    public void execute() {
        Printer.printCheatSheetList();
        askForSortingConfigAndPrint();
    }

    private void askForSortingConfigAndPrint() {
        System.out.println("Sort filter (na: name ascending, la: language ascending, nd: name descending"
            + ", ld: language descending or <enter> to skip)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("q")) {
            switch (input) {
            case "na":
                CheatSheetList.getCheatSheetList().sort(new SortByName());
                System.out.println("Currently sorting name in ascending order");
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
            Printer.printCheatSheetList();
            input = scanner.nextLine();
        }
    }
}
