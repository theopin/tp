package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.CommandFlag;
import sort.SortByLanguage;
import sort.SortByName;
import ui.Printer;

import java.io.IOException;
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
    public void execute() throws CommandException, IOException {
        String subject = "";
        String keyword = "";
        ArrayList<CheatSheet> cheatSheetArrayList = new ArrayList<>();
        SortFilter sortFilter = new SortFilter();

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
        sortFilter.execute();
    }

    private void printMatches(ArrayList<CheatSheet> cheatSheetArrayList) {
        printer.print("Showing all matches: ");
        for (CheatSheet cs : cheatSheetArrayList) {
            printer.printCheatSheet(cs);
            printer.printWhiteSpace();
        }
    }
}
