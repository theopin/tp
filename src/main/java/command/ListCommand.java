package command;

import cheatsheet.CheatSheet;
import sort.sortByName;
import sort.sortByLanguage;
import cheatsheet.CheatSheetList;
import parser.Parser;
import ui.Printer;

import java.util.Scanner;

public class ListCommand extends Command {
    public ListCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        Printer.printCheatSheetList();
        System.out.println("Sort filter (na: name ascending, la: language ascending, nd: name descending"
            + ", ld: language descending or <enter> to skip)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.isEmpty()) {
            switch (input) {
            case "na":
                CheatSheetList.getCheatSheetList().sort(new sortByName());
                break;
            case "la":
                CheatSheetList.getCheatSheetList().sort(new sortByLanguage());
                break;
            case "nd":
                CheatSheetList.getCheatSheetList().sort(new sortByName().reversed());
                break;
            case "ld":
                CheatSheetList.getCheatSheetList().sort(new sortByLanguage().reversed());
                break;
            }
            Printer.printCheatSheetList();
            input = scanner.nextLine();
        }
    }
}
