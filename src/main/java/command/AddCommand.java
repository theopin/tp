package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.Parser;

public class AddCommand extends Command {
    public AddCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        String name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
        String programmingLanguage = parser.getDescriptionMap().get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        String description = parser.getDescriptionMap().get(ArgumentFlagEnum.DESCRIPTION);

        CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
        CheatSheetList.add(cheatSheet);
    }
}
