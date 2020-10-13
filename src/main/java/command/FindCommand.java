package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() throws CommandException {
        String programmingLanguage = "";
        String keyword = "";
        ArrayList<CheatSheet> cheatSheetArrayList = new ArrayList<>();

        if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.PROGRAMMINGLANGUAGE)) {
            programmingLanguage = parser.getDescriptionMap().get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        }
        if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.SECTIONKEYWORD)) {
            keyword = parser.getDescriptionMap().get(ArgumentFlagEnum.SECTIONKEYWORD);
        }

        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            if (!programmingLanguage.isEmpty() && keyword.isEmpty()) {
                if (cs.getCheatSheetProgrammingLanguage().equals(programmingLanguage)) {
                    cheatSheetArrayList.add(cs);
                }
            } else if (!keyword.isEmpty() && programmingLanguage.isEmpty()) {
                if (cs.getCheatSheetDetails().contains(keyword)) {
                    cheatSheetArrayList.add(cs);
                }
            } else if (!programmingLanguage.isEmpty() && !keyword.isEmpty()) {
                if (cs.getCheatSheetProgrammingLanguage().equals(programmingLanguage)
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
        System.out.println("Showing all matches: ");
        for (CheatSheet cs : cheatSheetArrayList) {
            Printer.printCheatSheet(cs);
            Printer.printWhiteSpace();
        }
    }
}
