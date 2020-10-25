package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.CommandFlag;
import sort.SortByLanguage;
import sort.SortByName;
import ui.Printer;

import java.util.ArrayList;
import java.util.Scanner;

public class FindCommand extends FinderCommand {
    public static final String invoker = "/find";

    public FindCommand(Printer printer) {
        super(printer);

        flagsToDescriptions.put(CommandFlag.SUBJECT, null);
        flagsToDescriptions.put(CommandFlag.SECTIONKEYWORD, null);
        alternativeArguments.add(CommandFlag.SUBJECT);
        alternativeArguments.add(CommandFlag.SECTIONKEYWORD);
    }

    @Override
    public void execute() throws CommandException {
        String subject = "";
        String keyword = "";
        ArrayList<CheatSheet> cheatSheetArrayList = new ArrayList<>();

        if (flagsToDescriptions.containsKey(CommandFlag.SUBJECT)) {
            subject = flagsToDescriptions.get(CommandFlag.SUBJECT);
        }
        if (flagsToDescriptions.containsKey(CommandFlag.SECTIONKEYWORD)) {
            keyword = flagsToDescriptions.get(CommandFlag.SECTIONKEYWORD);
        }

        for (CheatSheet cs : CheatSheetList.getList()) {
            if (!subject.isEmpty() && keyword.isEmpty()) {
                if (cs.getSubject().contains(subject)) {
                    cheatSheetArrayList.add(cs);
                }
            } else if (!keyword.isEmpty() && subject.isEmpty()) {
                if (cs.getDetails().contains(keyword)) {
                    cheatSheetArrayList.add(cs);
                }
            } else if (!subject.isEmpty() && !keyword.isEmpty()) {
                if (cs.getSubject().contains(subject)
                        && cs.getDetails().contains(keyword)) {
                    cheatSheetArrayList.add(cs);
                }
            } else {
                throw new CommandException("Please enter at least an argument");
            }
        }

        if (cheatSheetArrayList.isEmpty()) {
            throw new CommandException("No matching content found");
        }

        printMatches(cheatSheetArrayList);
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

            printMatches(cheatSheetArrayList);
            input = scanner.nextLine();
        }
        askForSortingConfigAndPrint(cheatSheetArrayList);
    }

    private void printMatches(ArrayList<CheatSheet> cheatSheetArrayList) {
        printer.print("Showing all matches: ");
        for (CheatSheet cs : cheatSheetArrayList) {
            printer.printCheatSheet(cs);
            printer.printWhiteSpace();
        }
    }
}
