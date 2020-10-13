package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import parser.ArgumentFlagEnum;
import parser.Parser;

public class AddCommand extends Command {
    public AddCommand(Parser parser) {
        super(parser);
    }

    // todo: need ask theo how to implement the storage, now only cr8 cheatsheet got no content

    @Override
    public void execute() {
        String name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
        String programmingLanguage = parser.getDescriptionMap().get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        String description = parser.getDescriptionMap().get(ArgumentFlagEnum.DESCRIPTION);

        CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
        CheatSheetList.add(cheatSheet);
        System.out.println(cheatSheet + " has been added");
        System.out.println(CheatSheetList.getSize());
    }
}