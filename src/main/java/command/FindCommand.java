package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;
import ui.TablePrinter;

import java.util.ArrayList;

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

        ArrayList<CheatSheet> matchedContents = new ArrayList<>();

        String subject = flagsToDescriptions.get(CommandFlag.SUBJECT);
        String keyword = flagsToDescriptions.get(CommandFlag.SECTIONKEYWORD);

        for (CheatSheet cs : CheatSheetList.getList()) {
            if (checkCheatSheetExistsInCheatSheetList(cs, subject, keyword)) {
                matchedContents.add(cs);
            }
        }

        if (matchedContents.isEmpty()) {
            throw new CommandException("No matching content found");
        }

        //printMatches(matchedContents);
        TablePrinter tp = new TablePrinter(matchedContents);
        tp.execute();
        SortFilter sortFilter = new SortFilter();
        sortFilter.execute(tp);
    }

    /*
    private void printMatches(ArrayList<CheatSheet> cheatSheetArrayList) {
        printer.print("Showing all matches: ");
        for (CheatSheet cs : cheatSheetArrayList) {
            printer.printCheatSheet(cs);
            printer.printWhiteSpace();
        }
    }
    */
}
