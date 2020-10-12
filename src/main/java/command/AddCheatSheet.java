package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.ArgumentEnum;
import parser.Parser;

public class AddCheatSheet extends Command {
    public AddCheatSheet(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        String name = parser.getDescriptionMap().get(ArgumentEnum.NAME);
        String programmingLanguage = parser.getDescriptionMap().get(ArgumentEnum.PROGRAMMINGLANGUAGE);
        String description = parser.getDescriptionMap().get(ArgumentEnum.DESCRIPTION);

        CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
        CheatSheetList.add(cheatSheet);
    }
}
