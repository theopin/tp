package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import sort.SortByLanguage;
import sort.SortByName;
import ui.Printer;

import java.util.ArrayList;
import java.util.Scanner;

public class FindCommand extends FinderCommand {
    public FindCommand(Printer printer) {
        super(printer);

        initCommandDetails(new ArgumentFlagEnum[] {
            ArgumentFlagEnum.PROGRAMMINGLANGUAGE,
            ArgumentFlagEnum.SECTIONKEYWORD,
        });
    }

    @Override
    public boolean hasAllRequiredArguments() {
        if (descriptionMap.get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE) != null
            || descriptionMap.get(ArgumentFlagEnum.SECTIONKEYWORD) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void execute() throws CommandException {
        String programmingLanguage = "";
        String keyword = "";
        ArrayList<CheatSheet> cheatSheetArrayList = new ArrayList<>();

        if (descriptionMap.containsKey(ArgumentFlagEnum.PROGRAMMINGLANGUAGE)) {
            programmingLanguage = descriptionMap.get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        }
        if (descriptionMap.containsKey(ArgumentFlagEnum.SECTIONKEYWORD)) {
            keyword = descriptionMap.get(ArgumentFlagEnum.SECTIONKEYWORD);
        }

        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            if (!programmingLanguage.isEmpty() && keyword.isEmpty()) {
                if (cs.getCheatSheetProgrammingLanguage().contains(programmingLanguage)) {
                    cheatSheetArrayList.add(cs);
                }
            } else if (!keyword.isEmpty() && programmingLanguage.isEmpty()) {
                if (cs.getCheatSheetDetails().contains(keyword)) {
                    cheatSheetArrayList.add(cs);
                }
            } else if (!programmingLanguage.isEmpty() && !keyword.isEmpty()) {
                if (cs.getCheatSheetProgrammingLanguage().contains(programmingLanguage)
                        && cs.getCheatSheetDetails().contains(keyword)) {
                    cheatSheetArrayList.add(cs);
                }
            } else {
                throw new CommandException("Please enter at least an argument");
            }
        }

        if (cheatSheetArrayList.isEmpty()) {
            throw new CommandException("No matching content found");
        }

        printer.print("Showing all matches: ");
        for (CheatSheet cs : cheatSheetArrayList) {
            printer.printCheatSheet(cs);
            printer.printWhiteSpace();
        }
        askForSortingConfigAndPrint(cheatSheetArrayList);
    }

    protected void askForSortingConfigAndPrint(ArrayList<CheatSheet> cheatSheetArrayList) {
        printer.print("Sort filter (na: name ascending, la: language ascending, nd: name descending"
            + ", ld: language descending or <enter> to skip)");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.isEmpty()) {
            switch (input) {
            case "na":
                cheatSheetArrayList.sort(new SortByName());
                break;
            case "la":
                cheatSheetArrayList.sort(new SortByLanguage());
                break;
            case "nd":
                cheatSheetArrayList.sort(new SortByName().reversed());
                break;
            case "ld":
                cheatSheetArrayList.sort(new SortByLanguage().reversed());
                break;
            default:
                cheatSheetArrayList.sort(new SortByName());
            }

            printer.print("Showing all matches: ");
            for (CheatSheet cs : cheatSheetArrayList) {
                printer.printCheatSheet(cs);
                printer.printWhiteSpace();
            }
            input = scanner.nextLine();
        }
        askForSortingConfigAndPrint(cheatSheetArrayList);
    }
}
