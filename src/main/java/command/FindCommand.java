package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

public class FindCommand extends Command {
    public FindCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        String programmingLanguage = "";
        String keyword = "";

        if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.PROGRAMMINGLANGUAGE)) {
            programmingLanguage = parser.getDescriptionMap().get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        }
        if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.SECTIONKEYWORD)) {
            keyword = parser.getDescriptionMap().get(ArgumentFlagEnum.SECTIONKEYWORD);
        }
        System.out.println("Showing all matches: ");
        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            if (!programmingLanguage.isEmpty() && keyword.isEmpty()) {
                if (cs.getCheatSheetProgrammingLanguage().equals(programmingLanguage)) {
                    Printer.printCheatSheet(cs);
                    Printer.printWhiteSpace();
                }
            } else if (!keyword.isEmpty() && programmingLanguage.isEmpty()) {
                if (cs.getCheatSheetDetails().contains(keyword)) {
                    Printer.printCheatSheet(cs);
                    Printer.printWhiteSpace();
                }
            } else if (!programmingLanguage.isEmpty() && !keyword.isEmpty()) {
                if (cs.getCheatSheetProgrammingLanguage().equals(programmingLanguage)
                        && cs.getCheatSheetDetails().contains(keyword)) {
                    Printer.printCheatSheet(cs);
                    Printer.printWhiteSpace();
                }
            } else {
                Printer.printCheatSheet(cs);
                Printer.printWhiteSpace();
            }
        }
    }
}
