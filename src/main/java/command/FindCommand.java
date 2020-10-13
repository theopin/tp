package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.Parser;

public class FindCommand extends Command {
    public FindCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        String programmingLanguage = "";
        String keyword = "";

        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.PROGRAMMINGLANGUAGE)) {
                programmingLanguage = parser.getDescriptionMap().get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
            }
            if (parser.getDescriptionMap().containsKey(ArgumentFlagEnum.SECTIONKEYWORD)) {
                keyword = parser.getDescriptionMap().get(ArgumentFlagEnum.SECTIONKEYWORD);
            }
            if (!programmingLanguage.isEmpty() && keyword.isEmpty()) {
                if (cs.getCheatSheetProgrammingLanguage().equals(programmingLanguage)) {
                    System.out.println(cs);
                }
            } else if (!keyword.isEmpty() && programmingLanguage.isEmpty()) {
                if (cs.getCheatSheetDetails().contains(keyword)) {
                    System.out.println(cs);
                }
            } else if (!programmingLanguage.isEmpty() && !keyword.isEmpty()) {
                if (cs.getCheatSheetProgrammingLanguage().equals(programmingLanguage)
                        && cs.getCheatSheetDetails().contains(keyword)) {
                    System.out.println(cs);
                }
            } else {
                System.out.println("error");
            }
        }
    }
}
